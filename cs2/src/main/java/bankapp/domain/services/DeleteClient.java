package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.ClientPort;

@Service
public class DeleteClient {
    private final ClientPort clientPort;

    public DeleteClient(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

    public void deleteClient(String document) throws BusinessException {
        if (!clientPort.existsByDocument(document)) {
            throw new BusinessException("There is no client with that document.");
        }

        clientPort.deleteClient(document);
    }
}
