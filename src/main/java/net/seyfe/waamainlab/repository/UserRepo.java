package net.seyfe.waamainlab.repository;


import net.seyfe.waamainlab.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    public List<User> findAll();

    @Query(value = "SELECT u FROM User u WHERE u.posts.size > 1")
    public List<User> getUsersHavingMoreThanOnePost();

}
