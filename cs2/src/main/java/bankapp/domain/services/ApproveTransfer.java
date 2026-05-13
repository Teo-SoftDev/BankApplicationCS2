package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.TransferPort;
import bankapp.domain.models.Transfer;
import bankapp.domain.models.TransferState;

@Service
public class ApproveTransfer {
    private final TransferPort transferPort;

    public ApproveTransfer(TransferPort transferPort) {
        this.transferPort = transferPort;
    }

    public void approveTransfer(long idTransfer) throws BusinessException {
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
