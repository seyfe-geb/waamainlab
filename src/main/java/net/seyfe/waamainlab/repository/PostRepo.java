package net.seyfe.waamainlab.repository;



import net.seyfe.waamainlab.domain.Post;

import java.util.List;


public interface PostRepo {
    public List<Post> findAll();

    public Post findById(int postId);

    public void save(Post post);

    public void deleteById(int postId);

    public void updatePost(int postId, Post post);

    public List<Post> getPostByAuthor(String author);
}
