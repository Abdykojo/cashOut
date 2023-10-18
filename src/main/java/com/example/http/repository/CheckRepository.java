package com.example.http.repository;
import com.example.http.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface CheckRepository extends JpaRepository<Check,UUID> {


    Check getByQid (UUID qid);
    Optional<Check> findByQid (UUID qid);


}
