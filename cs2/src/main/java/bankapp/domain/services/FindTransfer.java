package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.TransferPort;
import bankapp.domain.models.Transfer;

public class FindTransfer {

    private TransferPort transferPort;

    public Transfer findById(long idTransfer) throws BusinessException {
        Transfer transfer = transferPort.findById(idTransfer);

        if (transfer == null) {
            throw new BusinessException("There's no transfer with that id.")
        }

        return transfer;
    }
}
