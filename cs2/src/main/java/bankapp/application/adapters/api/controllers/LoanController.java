package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.LoanRequest;
import bankapp.application.adapters.api.response.LoanResponse;
import bankapp.domain.models.Loan;
import bankapp.domain.models.LoanState;
import bankapp.domain.services.CreateLoan;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/loans")
@Getter
@Setter

public class LoanController {
    
    private CreateLoan createLoan;

    @PostMapping
    public LoanResponse createLoan(@RequestBody LoanRequest request) {
        Loan loan = new Loan();
        loan.setLoanType(request.getLoanType());
        loan.setRequestedAmount(request.getRequestedAmount());
        loan.setInterestRate(request.getInterestRate());
        loan.setTermInMonths(request.getTermInMonths());
        loan.setLoanState(LoanState.INSTUDY);

        createLoan.createLoan(loan);

        LoanResponse response = new LoanResponse();
        response.setId(loan.getLoanId());
        response.setLoanType(loan.getLoanType());
        response.setRequestedAmount(loan.getRequestedAmount());
        response.setApprovedAmount(loan.getApprovedAmount());
        response.setInterestRate(loan.getInterestRate());
        response.setTermInMonths(loan.getTermInMonths());
        response.setLoanState(loan.getLoanState());

        return response;
    }
}