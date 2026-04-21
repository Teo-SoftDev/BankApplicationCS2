package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.TransferPort;
import bankapp.domain.models.Transfer;
import bankapp.domain.models.TransferState;

public class ApproveTransfer {
    private TransferPort transferPort;

    public void approveLoan(long idTransfer) throws BusinessException {
        Transfer transfer = transferPort.findById(idTransfer);

        if (transfer == null) {
            throw new BusinessException("There's no transfer with that id.");
        }

        if (!transfer.getTransferState().equals(TransferState.PENDING)) {
            throw new BusinessException("Invalid status.");
        }

        transfer.setTransferState(TransferState.COMPLETED);

        transferPort.updateTransfer(transfer);
    }
}
