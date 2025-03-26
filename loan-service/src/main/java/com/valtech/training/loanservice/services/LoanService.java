package com.valtech.training.loanservice.services;

import java.util.List;

import com.valtech.training.loanservice.entities.Loan;

public interface LoanService {

	Loan applyLoan(Loan l);

	Loan getLoan(long id);

	List<Loan> getAllLoans();

}