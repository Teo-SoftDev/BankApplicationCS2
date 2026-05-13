package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.CreateTransferRequest;
import bankapp.application.adapters.api.response.AccountResponse;
import bankapp.application.adapters.api.response.LoanResponse;
import bankapp.application.adapters.api.response.TransferResponse;
import bankapp.application.usecases.CompanyEmployeeUseCase;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class CompanyEmployeeController {
    
    private CompanyEmployeeUseCase companyEmployeeUseCase;

    @PostMapping("/transfers")
    public TransferResponse createTransfer(@RequestBody CreateTransferRequest request) throws Exception {
        companyEmployeeUseCase.createTransfer(
            request.getOriginAccountNumber(),
            request.getDestinationAccountNumber(),
            request.getAmount()
        );
        return new TransferResponse();
    }

    @GetMapping("/accounts/{accountNumber}")
    public AccountResponse findAccountByAccountNumber(@PathVariable String accountNumber) throws Exception {
        var account = companyEmployeeUseCase.findAccountByAccountNumber(accountNumber);
        return AccountResponse.fromAccount(account);
    }

    @GetMapping("/transfers/{transferId}")
    public TransferResponse findTransferById(@PathVariable long transferId) throws Exception {
        var transfer = companyEmployeeUseCase.findTransferById(transferId);
        return TransferResponse.fromTransfer(transfer);
    }

    @GetMapping("/loans/{loanId}")
    public LoanResponse findLoanById(@PathVariable long loanId) throws Exception {
        var loan = companyEmployeeUseCase.findLoanById(loanId);
        return LoanResponse.fromLoan(loan);
    }
}
