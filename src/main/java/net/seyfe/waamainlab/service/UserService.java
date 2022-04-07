package net.seyfe.waamainlab.service;



import net.seyfe.waamainlab.domain.Comment;
import net.seyfe.waamainlab.domain.Post;
import net.seyfe.waamainlab.domain.User;
import net.seyfe.waamainlab.domain.dto.CommentDto;
import net.seyfe.waamainlab.domain.dto.PostDto;
import net.seyfe.waamainlab.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long userId);

    void save(User user);

    public void deleteById(Long userId);

    public void updateUser(Long postId, User user);

    public List<UserDto> getPostByUserName(String userName);

    List<PostDto> findPostsByUserId(Long userId);

    List<UserDto> getUsersHavingMoreThanOnePost();

    List<CommentDto> findCommentsById(Long userId, Long postId);

    List<PostDto> findPostsByPostId(Long userId, Long postId);

    void savePost(Long userId, Post post);

    void saveComment(Long userId, Long postId, Comment comment);
}
