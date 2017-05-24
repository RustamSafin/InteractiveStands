package com.prover.prover.services;

import com.prover.prover.models.Pattern;
import com.prover.prover.repositories.PatternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 21.05.2017.
 */
@Service
public class PatternService {
    private final PatternRepository patternRepository;

    @Autowired
    public PatternService(PatternRepository patternRepository) {
        this.patternRepository = patternRepository;
    }

    public List<Pattern> getByIds(List<Long> pattenIds) {
        return (List<Pattern>) patternRepository.findAllById(pattenIds);
    }

    public List<Pattern> findAll() {
        return (List<Pattern>) patternRepository.findAll();
    }
}
