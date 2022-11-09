package org.example.controller;

import org.example.model.Contest;
import org.example.services.SuperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


//Ignore this as it is Spring and not Java EE (Jax-RS) controller
@RestController
@CrossOrigin("http://localhost:3005")
public class MyController {

    private SuperRepository superRepository;

    //you should generally favour constructor/setter injection over field injection
    @Autowired
    public MyController(SuperRepository superRepository){
        this.superRepository = superRepository;
    }


    @PostMapping("/createContest")
    public Contest createContest(@RequestBody Contest contest){
        return superRepository.createContest(contest);
    }


    @GetMapping("/getContest")
    public List<Contest> getContest() {
        return superRepository.getContest();
    }
}

