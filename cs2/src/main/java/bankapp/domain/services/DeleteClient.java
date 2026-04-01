package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.ClientPort;

public class DeleteClient {
    private ClientPort clientPort;

    public void deleteClient(String document) throws BusinessException {
        if (!clientPort.existsByDocument(document)) {
            throw new BusinessException("There is no client with that document.");
        }

        clientPort.deleteClient(document);
    }
}
