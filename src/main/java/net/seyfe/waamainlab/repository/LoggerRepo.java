package net.seyfe.waamainlab.repository;


import net.seyfe.waamainlab.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {
    List<Logger> findAll();
}
