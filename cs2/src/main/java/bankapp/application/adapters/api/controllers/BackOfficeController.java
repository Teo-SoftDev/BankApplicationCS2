package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.ApprovalRequest;
// import bankapp.application.adapters.api.request.FindClientRequest;
import bankapp.application.adapters.api.request.FindLoanByClientRequest;
import bankapp.application.adapters.api.request.FindTransferByClientRequest;
import bankapp.application.adapters.api.response.AccountResponse;
import bankapp.application.adapters.api.response.ClientResponse;
import bankapp.application.adapters.api.response.LoanResponse;
import bankapp.application.adapters.api.response.TransferResponse;
import bankapp.application.usecases.BackOfficeUseCase;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/backoffice")
@AllArgsConstructor
public class BackOfficeController {
    
    private BackOfficeUseCase backOfficeUseCase;

    @GetMapping("/clients/{document}")
    public ClientResponse findClientByDocument(@PathVariable String document) throws Exception {
        var client = backOfficeUseCase.findClientByDocument(document);
        return ClientResponse.fromClient(client);
    }

    @GetMapping("/accounts/{accountNumber}")
    public AccountResponse findAccountByAccountNumber(@PathVariable String accountNumber) throws Exception {
        var account = backOfficeUseCase.findAccountByAccountNumber(accountNumber);
        return AccountResponse.fromAccount(account);
    }

    @GetMapping("/loans/{loanId}")
    public LoanResponse findLoanById(@PathVariable long loanId) throws Exception {
        var loan = backOfficeUseCase.findLoanById(loanId);
        return LoanResponse.fromLoan(loan);
    }

    @PostMapping("/loans/by-client")
    public List<LoanResponse> findLoanByClient(@RequestBody FindLoanByClientRequest request) throws Exception {
        var loans = backOfficeUseCase.findLoanByClient(request.getDocument(), request.getUser());
        return loans.stream().map(LoanResponse::fromLoan).collect(Collectors.toList());
    }

    @GetMapping("/transfers/{transferId}")
    public TransferResponse findTransferById(@PathVariable long transferId) throws Exception {
        var transfer = backOfficeUseCase.findTransferById(transferId);
        return TransferResponse.fromTransfer(transfer);
    }

    @PostMapping("/transfers/by-client")
    public List<TransferResponse> findTransferByClient(@RequestBody FindTransferByClientRequest request) throws Exception {
        var transfers = backOfficeUseCase.findTransferByClient(request.getDocument(), request.getUser());
        return transfers.stream().map(TransferResponse::fromTransfer).collect(Collectors.toList());
    }

    @PostMapping("/loans/{loanId}/approve")
    public void approveLoan(@PathVariable long loanId) throws Exception {
        backOfficeUseCase.approveLoan(loanId);
    }

    @PostMapping("/transfers/{transferId}/approve")
    public void approveTransfer(@PathVariable long transferId) throws Exception {
        backOfficeUseCase.approveTransfer(transferId);
    }
}
