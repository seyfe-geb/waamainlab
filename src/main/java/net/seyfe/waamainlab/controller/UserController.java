package net.seyfe.waamainlab.controller;



import net.seyfe.waamainlab.domain.User;
import net.seyfe.waamainlab.domain.dto.PostDto;
import net.seyfe.waamainlab.domain.dto.UserDto;
import net.seyfe.waamainlab.service.PostService;
import net.seyfe.waamainlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId")Long userId){

        return ResponseEntity.ok(userService.findById(userId));
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<PostDto>> getUserPostsById(@PathVariable("userId")Long userId){

        return ResponseEntity.ok(userService.findPostsById(userId));
    }

    @GetMapping("/user")
    public List<UserDto> getPostsByUserName(@RequestParam("name") String name){

        return userService.getPostByUserName(name);
    }

    @GetMapping("/users-having-more-than-one-posts")
    public List<UserDto> getUsersHavingMoreThanOnePost(){

        return userService.getUsersHavingMoreThanOnePost();
    }

    @PostMapping
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable("userId")Long userId){
        userService.deleteById(userId);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestBody User user){

        userService.updateUser(userId, user);
    }
}
