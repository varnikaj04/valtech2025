package com.valtech.training.loanservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.loanservice.entities.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
