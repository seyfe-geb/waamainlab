package net.seyfe.waamainlab.repository;


import net.seyfe.waamainlab.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findAll();
}
