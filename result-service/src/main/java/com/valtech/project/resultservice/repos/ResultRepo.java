package com.valtech.project.resultservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.project.resultservice.entities.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {

}
