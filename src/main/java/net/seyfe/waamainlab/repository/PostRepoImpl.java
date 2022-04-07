package net.seyfe.waamainlab.repository;


import net.seyfe.waamainlab.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo{

    private static List<Post> posts;
    private static int postsId = 5;

    static{
        posts = new ArrayList<>(){
            {
                add(new Post(1, "Goodluck", "Good luck on your exams, everyone", "Seyfe"));
                add(new Post(2, "Happy new year", "Happy new year 2022, everyone", "zidane"));
                add(new Post(3, "Rainy", "Becareful everyone, it is ainy today", "RD. Sung"));
                add(new Post(4, "Snow", "Don't forget to put on your snow gears.", "Dean of Students"));
            }
        };
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int postId) {

        return posts.stream()
                .filter(p -> p.getId() == postId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(postsId);
        postsId++;
        posts.add(post);
    }

    @Override
    public void deleteById(int postId) {
        Post product = posts.stream()
                .filter(p -> p.getId() == postId)
                .findFirst().get();
        posts.remove(product);
    }

    @Override
    public void updatePost(int postId, Post post) {
        Post toUpdate = findById(postId);
        toUpdate.setTitle(post.getTitle());
        toUpdate.setContent(post.getContent());
        toUpdate.setAuthor(post.getAuthor());
    }

    @Override
    public List<Post> getPostByAuthor(String author) {
        return posts.stream()
                .filter(p -> p.getAuthor().equals(author))
                .collect(Collectors.toList());
    }
}
