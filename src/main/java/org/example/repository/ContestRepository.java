package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.example.model.Contest;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ContestRepository extends JpaRepository<Contest, Long> {
    Contest findByName(String name);

    List<Contest> findAll();
}

