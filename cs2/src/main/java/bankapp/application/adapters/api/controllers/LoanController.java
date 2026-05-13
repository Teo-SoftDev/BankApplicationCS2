package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.CreateLoanRequest;
import bankapp.application.adapters.api.response.LoanResponse;
import bankapp.application.usecases.ProductAdvisorUseCase;
import bankapp.domain.models.Client;
import bankapp.domain.models.Loan;
import bankapp.domain.services.FindClient;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/loans")
@AllArgsConstructor
public class LoanController {
    
    private ProductAdvisorUseCase productAdvisorUseCase;
    private FindClient findClient;

    @PostMapping
    public LoanResponse createLoan(@RequestBody CreateLoanRequest request) throws Exception {
        Loan loan = CreateLoanRequest.toEntity(request);
        
        // Find client by document
        Client client = findClient.findByDocument(request.getClientDocument());
        
        productAdvisorUseCase.createLoan(client, loan);
        return LoanResponse.fromLoan(loan);
    }
}