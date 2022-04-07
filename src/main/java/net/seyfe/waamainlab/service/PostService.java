package net.seyfe.waamainlab.service;



import net.seyfe.waamainlab.domain.Post;
import net.seyfe.waamainlab.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto findById(int productID);

    void save(Post product);

    public void deleteById(int postId);

    public void updatePost(int postId, Post post);

    public List<PostDto> getPostByAuthor(String author);
}
