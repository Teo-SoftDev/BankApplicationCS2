package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.ApprovalRequest;
import bankapp.application.adapters.api.request.FindLoanByClientRequest;
import bankapp.application.adapters.api.request.FindTransferByClientRequest;
import bankapp.application.adapters.api.response.LoanResponse;
import bankapp.application.adapters.api.response.TransferResponse;
import bankapp.application.usecases.CompanySupervisorUseCase;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/supervisor")
@AllArgsConstructor
public class CompanySupervisorController {
    
    private CompanySupervisorUseCase companySupervisorUseCase;

    @PostMapping("/loans/{loanId}/approve")
    public void approveLoan(@PathVariable long loanId) throws Exception {
        companySupervisorUseCase.approveLoan(loanId);
    }

    @PostMapping("/transfers/{transferId}/approve")
    public void approveTransfer(@PathVariable long transferId) throws Exception {
        companySupervisorUseCase.approveTransfer(transferId);
    }

    @PostMapping("/loans/by-client")
    public List<LoanResponse> findLoanByClient(@RequestBody FindLoanByClientRequest request) throws Exception {
        var loans = companySupervisorUseCase.findLoanByClient(request.getDocument(), request.getUser());
        return loans.stream().map(LoanResponse::fromLoan).collect(Collectors.toList());
    }

    @PostMapping("/transfers/by-client")
    public List<TransferResponse> findTransferByClient(@RequestBody FindTransferByClientRequest request) throws Exception {
        var transfers = companySupervisorUseCase.findTransferByClient(request.getDocument(), request.getUser());
        return transfers.stream().map(TransferResponse::fromTransfer).collect(Collectors.toList());
    }
}
