package com.valtech.training.loanservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.loanservice.entities.Loan;
import com.valtech.training.loanservice.entities.Loan.LoanStatus;
import com.valtech.training.loanservice.entities.Loan.LoanType;

public record LoanVO(int id, String userName, int aadhar, int cibilScore, String loanType, String asset, int assetValue,
		int value, int income, String loanStatus) {

	public static LoanVO from(Loan loan) {
		return new LoanVO(loan.getId(), loan.getUserName(), loan.getAadhar(), loan.getCibilScore(),
				loan.getLoanType().name(), loan.getAsset(), loan.getAssetValue(), loan.getValue(), loan.getIncome(),
				loan.getStatus().name());
	}

	public static List<LoanVO> from(List<Loan> loans) {
		return loans.stream().map(loan -> LoanVO.from(loan)).collect(Collectors.toList());
	}

	public Loan to() {
		return new Loan(userName, aadhar, cibilScore, LoanType.valueOf(loanType), asset, assetValue, value, income,
				LoanStatus.valueOf(loanStatus));
	}

}
