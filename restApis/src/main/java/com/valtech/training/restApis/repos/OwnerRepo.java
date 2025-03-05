package com.valtech.training.restApis.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.restApis.entities.Owner;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long> {

}
