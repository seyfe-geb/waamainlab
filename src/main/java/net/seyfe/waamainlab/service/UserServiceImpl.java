package net.seyfe.waamainlab.service;


import net.seyfe.waamainlab.domain.Comment;
import net.seyfe.waamainlab.domain.Post;
import net.seyfe.waamainlab.domain.User;
import net.seyfe.waamainlab.domain.dto.CommentDto;
import net.seyfe.waamainlab.domain.dto.PostDto;
import net.seyfe.waamainlab.domain.dto.UserDto;
import net.seyfe.waamainlab.helper.ListMapper;
import net.seyfe.waamainlab.repository.PostRepo;
import net.seyfe.waamainlab.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Comment, CommentDto> listMapperCommentToCommentDto;

    @Autowired
    ListMapper<User, UserDto> listMapperUserToUserDto;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToPostDto;

    @Override
    public List<UserDto> findAll() {

        return (List<UserDto>)listMapperUserToUserDto.mapList(userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto findById(Long userId) {

        return modelMapper.map(userRepo.findById(userId).orElse(null), UserDto.class);
    }

    @Override
    public void save(User user) {

        userRepo.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        userRepo.deleteById(userId);
    }

    @Transactional
    @Override
    public void updateUser(Long userId, User user) {
        User oldUser = userRepo.findById(userId).orElse(null);
        oldUser.setName(user.getName());
    }

    @Override
    public List<UserDto> getPostByUserName(String userName) {
        return null;
    }

    @Override
    public List<PostDto> findPostsByUserId(Long userId) {
        return (List<PostDto>)listMapperPostToPostDto.mapList(userRepo.findById(userId).get().getPosts(), new PostDto());
    }

    @Override
    public List<UserDto> getUsersHavingMoreThanOnePost() {
        return (List<UserDto>)listMapperUserToUserDto.mapList(userRepo.getUsersHavingMoreThanOnePost(), new UserDto());
    }

    @Override
    public List<CommentDto> findCommentsById(Long userId, Long postId) {
        List<Post> posts = userRepo.findById(userId).orElse(null).getPosts();
        List<Comment> comments = posts.stream()
                .filter(p -> p.getId() == postId)
                .flatMap(p -> p.getComments().stream())
                .collect(Collectors.toList());
        return (List<CommentDto>)listMapperCommentToCommentDto.mapList(comments, new CommentDto());
    }

    @Override
    public List<PostDto> findPostsByPostId(Long userId, Long postId) {
        List<Post> posts = userRepo.findById(userId).orElse(null).getPosts()
                                .stream()
                                .filter(p -> p.getId() == postId)
                                .collect(Collectors.toList());
        return (List<PostDto>)listMapperPostToPostDto.mapList(posts, new PostDto());
    }

    @Transactional
    @Override
    public void savePost(Long userId, Post post) {
        User user = userRepo.findById(userId).orElse(null);
        user.getPosts().add(post);
    }

    @Transactional
    @Override
    public void saveComment(Long userId, Long postId, Comment comment) {
        User user = userRepo.findById(userId).orElse(null);
        user.getPosts().stream()
                        .filter(p -> p.getId() == postId)
                        .findFirst().orElse(null)
                        .getComments().add(comment);
    }
}
