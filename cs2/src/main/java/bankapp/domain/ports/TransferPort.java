package bankapp.domain.ports;

import bankapp.domain.models.Transfer;

public interface TransferPort {
    // if the transfer already exists
    public boolean existsById(long transferId);

    public Loan findById(long transferId);

    public void saveTransfer(Transfer transfer);
    public void updateTransfer(Transfer transfer);

}