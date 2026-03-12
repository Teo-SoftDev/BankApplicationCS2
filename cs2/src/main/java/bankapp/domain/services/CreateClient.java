package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.ClientPort;
import bankapp.domain.models.Client;

public class CreateClient {
    
    private ClientPort clientPort;

    public void createClient(Client client) throws BusinessException {

        if (clientPort.existsByDocument(client.getDocument())) {
            throw new BusinessException("Client already exists");
        }

        clientPort.saveClient(client);

    }
}
