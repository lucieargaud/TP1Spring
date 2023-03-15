package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Soliste;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface ISolisteRepository extends JpaRepository<Soliste, Integer> {

}
