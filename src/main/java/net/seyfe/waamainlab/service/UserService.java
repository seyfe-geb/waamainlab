package net.seyfe.waamainlab.service;



import net.seyfe.waamainlab.domain.User;
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

    List<PostDto> findPostsById(Long userId);

    List<UserDto> getUsersHavingMoreThanOnePost();
}
