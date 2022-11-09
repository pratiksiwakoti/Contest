package org.example.services;


import org.example.model.Contest;
//import edu.baylor.cs.se.hibernate.services.ContestRepository;
//import edu.baylor.cs.se.hibernate.services.TeamRepository;
import java.text.SimpleDateFormat;
import java.util.*;

import org.example.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//Spring annotations, feel free to ignore it
@Service
@Transactional
public class SuperRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ContestRepository crepo;



    public SuperRepository(ContestRepository crepo) {
        this.crepo = crepo;
    }




    public Contest createContest(Contest contest){
        return crepo.save(contest);
    }

    public List<Contest> getContest(){
        return crepo.findAll();
    }

}

