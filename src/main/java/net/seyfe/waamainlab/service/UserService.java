package net.seyfe.waamainlab.service;


import net.seyfe.waamainlab.domain.*;
import net.seyfe.waamainlab.domain.dto.*;
import net.seyfe.waamainlab.domain.dto.request.LoginRequest;
import net.seyfe.waamainlab.domain.dto.request.RefreshTokenRequest;
import net.seyfe.waamainlab.domain.dto.response.LoginResponse;

import java.time.*;
import java.util.*;

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

    void logException(LocalDate date, LocalTime time, String principle, String operation, String exceptionType);

    List<UserDto> getUsersByPostTitle(String title);

}
