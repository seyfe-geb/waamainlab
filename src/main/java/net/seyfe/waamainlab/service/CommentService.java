package net.seyfe.waamainlab.service;



import net.seyfe.waamainlab.domain.Comment;
import net.seyfe.waamainlab.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();

    CommentDto findById(Long commentId);

    void save(Comment comment);

    public void deleteById(Long commentId);

    public void updateComment(Long commentId, Comment comment);

    List<CommentDto> findCommentsById(Long userId, Long postId);
}
