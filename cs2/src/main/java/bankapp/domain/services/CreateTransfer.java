package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.TransferPort;
import bankapp.domain.models.Transfer;

public class CreateTransfer {
    
    private TransferPort transferPort;

    public void createTransfer(Transfer transfer) throws BusinessException {

        if (transferPort.existsById(transfer.getIdTransfer())){
            throw new BusinessException("There's already a transfer with that id.");
        }

        transferPort.saveTransfer(transfer);

    }
}
