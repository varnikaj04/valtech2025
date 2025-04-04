package com.valtech.training.loanservice.services;

import java.util.List;

import com.valtech.training.loanservice.entities.Loan;
import com.valtech.training.loanservice.vos.LoanVO;

public interface LoanService {

	Loan processLoan(LoanVO loanVO);

	LoanVO applyForLoan(LoanVO lvo);

	List<LoanVO> getAllLoans();

	LoanVO getLoan(int id);

	LoanVO saveLoan(LoanVO lvo);


}