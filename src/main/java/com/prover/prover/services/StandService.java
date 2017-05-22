package com.prover.prover.services;

import com.prover.prover.models.Pattern;
import com.prover.prover.models.Stand;
import com.prover.prover.repositories.StandRepository;
import com.prover.prover.utils.Constants;
import com.prover.prover.utils.helpers.UserHelper;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 21.05.2017.
 */
@Service
public class StandService {

    private final StandRepository standRepository;

    @Autowired
    public StandService(StandRepository standRepository) {
        this.standRepository = standRepository;
    }
    @Transactional
    public Stand getOne(Long id){
        Stand stand= standRepository.getOne(id);
        stand = (Stand) Hibernate.unproxy(stand);
        stand.setPatterns(stand.getPatterns());
        return stand;
    }

    public void delete(Stand stand) {
        standRepository.delete(stand);
    }

    @Transactional
    public void update(Stand stand) {
        standRepository.save(stand);
    }

    @Transactional
    public Stand save(String text, String title, List<Pattern> patterns) {
        Stand stand= new Stand();
        stand.setBody(text);
        stand.setTitle(title);
//        stand.setUser(UserHelper.currentUser());
        stand.getPatterns().addAll(patterns);

        return standRepository.save(stand);
    }

    public List<Stand> findByPatterns(List<Long> patternIds, Integer page) {
        return standRepository.findAllByPatternsIdIn(
                patternIds,
                PageRequest.of(page,
                        Constants.STANDS_LIMIT,
                        new Sort(Sort.Direction.ASC,
                                "patterns.id")
                )
        ).getContent();
    }

    public List<Stand> findAll(Integer page) {
        return standRepository.findAll(
                PageRequest.of(
                        page,
                        Constants.STANDS_LIMIT,
                        new Sort(Sort.Direction.ASC,
                                "patterns.id")
                )).getContent();
    }
}
