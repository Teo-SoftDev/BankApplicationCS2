package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.CreateTransferRequest;
import bankapp.application.adapters.api.response.TransferResponse;
import bankapp.application.usecases.CompanyEmployeeUseCase;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/transfers")
@AllArgsConstructor
public class TransferController {
    
    private CompanyEmployeeUseCase companyEmployeeUseCase;

    @PostMapping
    public TransferResponse createTransfer(@RequestBody CreateTransferRequest request) throws Exception {
        companyEmployeeUseCase.createTransfer(
            request.getOriginAccountNumber(),
            request.getDestinationAccountNumber(),
            request.getAmount()
        );
        return new TransferResponse();
    }
}