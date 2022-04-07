package net.seyfe.waamainlab.controller;



import net.seyfe.waamainlab.domain.Post;
import net.seyfe.waamainlab.domain.dto.PostDto;
import net.seyfe.waamainlab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDto> getPosts(){
        return postService.findAll();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("postId")int postId){

        return ResponseEntity.ok(postService.findById(postId));
    }

    @GetMapping("/auth")
    public List<PostDto> printSomething(@RequestParam("author") String author){

        return postService.getPostByAuthor(author);
    }

    @PostMapping
    public void savePost(@RequestBody Post post){
        postService.save(post);
    }

    @DeleteMapping("/{postId}")
    public void deleteById(@PathVariable("postId")int postId){
        postService.deleteById(postId);
    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable("postId") int postId,
                           @RequestBody Post post){

        postService.updatePost(postId, post);
    }

}
