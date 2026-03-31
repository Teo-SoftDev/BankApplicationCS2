package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Client;
import bankapp.domain.ports.ClientPort;

public class UpdateClient {
    private ClientPort clientPort;

    public void updateClient(Client client) throws BusinessException {
        if (!clientPort.existsByDocument(client.getDocument())) {
            throw new BusinessException("There is no client with that document.");
        }

        clientPort.updateClient(client);
    }
}