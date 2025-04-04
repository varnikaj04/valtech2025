package com.valtech.training.loanservice.webservices;

import java.util.List;

import com.valtech.training.loanservice.entities.Loan;

public interface LoanServiceWS {

	Loan createLoan(Loan loan);

	Loan getLoan(int id);

	List<Loan> getAllLoans();

	Loan applyForLoan(Loan loan);

}