package com.valtech.training.loanserviceclient.webservices;

import java.util.List;

import com.valtech.training.loanserviceclient.entities.Loan;


public interface LoanServiceWS {
	
	Loan createLoan(Loan loan);

	Loan getLoan(int id);

	List<Loan> getAllLoans();

	Loan applyForLoan(Loan loan);

}
