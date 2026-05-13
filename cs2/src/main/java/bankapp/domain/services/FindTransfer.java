package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.TransferPort;
import bankapp.domain.models.Transfer;
import java.util.List;

import org.springframework.stereotype.Service;

import bankapp.domain.models.Client;
import bankapp.domain.models.User;
import bankapp.domain.ports.ClientPort;

@Service
public class FindTransfer {

    private final TransferPort transferPort;
    private final ClientPort clientPort;

    public FindTransfer(TransferPort transferPort, ClientPort clientPort) {
        this.transferPort = transferPort;
        this.clientPort = clientPort;
    }

    public Transfer findById(long idTransfer) throws BusinessException {
        Transfer transfer = transferPort.findById(idTransfer);

        if (transfer == null) {
            throw new BusinessException("There's no transfer with that id.");
        }

        return transfer;
    }

    public List<Transfer> findTransferByClient(String document, User user) throws BusinessException {
        Client client = clientPort.findByDocument(document);

        if(client == null) {
            throw new BusinessException("There's no client with the document" + document);
        }

        return transferPort.findTransferByClient(client);
    }
}
