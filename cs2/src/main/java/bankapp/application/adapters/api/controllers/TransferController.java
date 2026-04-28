package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.TransferRequest;
import bankapp.application.adapters.api.response.TransferResponse;
import bankapp.domain.models.Transfer;
import bankapp.domain.models.TransferState;
import bankapp.domain.services.CreateTransfer;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/transfers")
@Getter
@Setter

public class TransferController {
    
    private CreateTransfer createTransfer;

    @PostMapping
    public TransferResponse createTransfer(@RequestBody TransferRequest request) {
        Transfer transfer = new Transfer();
        transfer.setAmount(request.getAmount());
        transfer.setTransferState(TransferState.PENDING);

        createTransfer.createTransfer(transfer);

        TransferResponse response = new TransferResponse();
        response.setId(transfer.getIdTransfer());
        response.setAmount(transfer.getAmount());
        response.setCreationDate(transfer.getCreationDate());
        response.setTransferState(transfer.getTransferState());

        return response;
    }
}