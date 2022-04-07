package net.seyfe.waamainlab.repository;


import net.seyfe.waamainlab.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    public List<User> findAll();

//    public List<User> findPostByUserName(String name);
    @Query(value = "SELECT * FROM post WHERE user_id > 1", nativeQuery = true)
    public List<User> getUsersHavingMoreThanOnePost();
}
