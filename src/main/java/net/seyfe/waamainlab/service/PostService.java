package net.seyfe.waamainlab.service;



import net.seyfe.waamainlab.domain.Post;
import net.seyfe.waamainlab.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto findById(Long productID);

    void save(Post product);

    public void deleteById(Long postId);

    public void updatePost(Long postId, Post post);

    public List<PostDto> getPostByAuthor(String author);

    List<PostDto> getPostsByTitle(String title);
}
