package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Concert;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface IConcertRepository extends JpaRepository<Concert, Integer> {

}
