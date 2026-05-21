package bankapp.domain.ports;

import bankapp.domain.models.Transfer;
import java.util.List;
import bankapp.domain.models.Client;

public interface TransferPort {
    // if the transfer already exists
    public boolean existsById(Long transferId);

    public Transfer findById(Long transferId);

    public List<Transfer> findTransferByClient(Client requestingClient);

    public void saveTransfer(Transfer transfer);
    public void updateTransfer(Transfer transfer);

}