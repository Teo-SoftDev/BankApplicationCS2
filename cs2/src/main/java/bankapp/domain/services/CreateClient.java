package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.ClientPort;
import bankapp.domain.models.Client;

public class CreateClient {
    
    private ClientPort clientPort;

    public void createClient(Client client) throws BusinessException {

        if (clientPort.existsByDocument(client.getDocument())) {
            throw new BusinessException("There is already a client with that document.");
        }
        if (clientPort.existsByEmail(client.getEmail())) {
            throw new BusinessException("There is already a client with that email.");
        }

        clientPort.saveClient(client);

    }
}
