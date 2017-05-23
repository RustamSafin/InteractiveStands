package com.prover.prover.repositories;

import com.prover.prover.models.Stand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 21.05.2017.
 */
@Repository
public interface StandRepository extends JpaRepository<Stand,Long> {
    Page<Stand> findAllByPatternsIdIn(List<Long> patternIds, Pageable pageable);
    Integer countAllByPatternsIdIn(List<Long> patternIds);
}
