package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.AccountRequest;
import bankapp.application.adapters.api.request.CreateLoanRequest;
import bankapp.application.adapters.api.response.AccountResponse;
import bankapp.application.adapters.api.response.LoanResponse;
import bankapp.application.usecases.ProductAdvisorUseCase;
import bankapp.domain.models.Account;
import bankapp.domain.models.Client;
import bankapp.domain.models.Loan;
import bankapp.domain.services.FindClient;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/advisor")
@AllArgsConstructor
public class ProductAdvisorController {
    
    private ProductAdvisorUseCase productAdvisorUseCase;
    private FindClient findClient;

    @PostMapping("/accounts")
    public AccountResponse createAccount(@RequestBody AccountRequest request) throws Exception {
        Account account = AccountRequest.toEntity(request);
        
        // Find client by document if provided
        Client client = request.getClientDocument() != null ? 
            findClient.findByDocument(request.getClientDocument()) : null;
        
        productAdvisorUseCase.createAccount(client, account);
        return AccountResponse.fromAccount(account);
    }

    @GetMapping("/accounts/{accountNumber}")
    public AccountResponse findAccountByAccountNumber(@PathVariable String accountNumber) throws Exception {
        var account = productAdvisorUseCase.findAccountByAccountNumber(accountNumber);
        return AccountResponse.fromAccount(account);
    }

    @PostMapping("/loans")
    public LoanResponse createLoan(@RequestBody CreateLoanRequest request) throws Exception {
        Loan loan = CreateLoanRequest.toEntity(request);
        
        // Find client by document
        Client client = findClient.findByDocument(request.getClientDocument());
        
        productAdvisorUseCase.createLoan(client, loan);
        return LoanResponse.fromLoan(loan);
    }

    @GetMapping("/loans/{loanId}")
    public LoanResponse findLoanById(@PathVariable long loanId) throws Exception {
        var loan = productAdvisorUseCase.findLoanById(loanId);
        return LoanResponse.fromLoan(loan);
    }
}
