package com.prover.prover.repositories;

import com.prover.prover.models.Stand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 21.05.2017.
 */
@Repository
public interface StandRepository extends JpaRepository<Stand,Long> {
}
