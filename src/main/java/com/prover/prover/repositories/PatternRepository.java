package com.prover.prover.repositories;

import com.prover.prover.models.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 21.05.2017.
 */
@Repository
public interface PatternRepository extends CrudRepository<Pattern,Long> {

}
