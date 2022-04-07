package net.seyfe.waamainlab.service;


import net.seyfe.waamainlab.domain.Post;
import net.seyfe.waamainlab.domain.dto.PostDto;
import net.seyfe.waamainlab.helper.ListMapper;
import net.seyfe.waamainlab.repository.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepo postRepo;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToPostDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToPostDto.mapList(postRepo.findAll(), new PostDto());

    }

    @Override
    public PostDto findById(int postID) {
        return modelMapper.map(postRepo.findById(postID), PostDto.class);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void deleteById(int postId) {
        postRepo.deleteById(postId);
    }

    @Override
    public void updatePost(int postId, Post post) {
        postRepo.updatePost(postId, post);
    }

    @Override
    public List<PostDto> getPostByAuthor(String author) {
        return (List<PostDto>)listMapperPostToPostDto.mapList(postRepo.getPostByAuthor(author), new PostDto());
    }
}
