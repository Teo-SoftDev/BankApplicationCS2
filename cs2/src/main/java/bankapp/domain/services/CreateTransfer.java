package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.TransferPort;
import bankapp.domain.models.Transfer;

@Service
public class CreateTransfer {
    
    private final TransferPort transferPort;

    public CreateTransfer(TransferPort transferPort) {
        this.transferPort = transferPort;
    }

    public void createTransfer(Transfer transfer) throws BusinessException {

        if (transferPort.existsById(transfer.getIdTransfer())){
            throw new BusinessException("There's already a transfer with that id.");
        }

        transferPort.saveTransfer(transfer);

    }
}
