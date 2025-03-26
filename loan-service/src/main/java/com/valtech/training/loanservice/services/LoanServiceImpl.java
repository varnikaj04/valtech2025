package com.valtech.training.loanservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.loanservice.entities.Loan;
import com.valtech.training.loanservice.repos.LoanRepo;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepo loanRepo;
	
	@Override
	public Loan applyLoan(Loan l) {
		return loanRepo.save(l);
	}
	
	@Override
	public Loan getLoan(long id) {
		return loanRepo.getReferenceById(id);
	}
	
	@Override
	public List<Loan> getAllLoans(){
		return loanRepo.findAll();
	}

}
