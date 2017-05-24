package com.prover.prover.repositories;

import com.prover.prover.models.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Admin on 23.05.2017.
 */
@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
    @Query("SELECT id from Images")
    List<Long> findAllId();
}
