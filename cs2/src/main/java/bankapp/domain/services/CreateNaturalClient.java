package bankapp.domain.services;

import bankapp.domain.ports.ClientPort;
import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Client;
import bankapp.domain.models.ClientRole;

public class CreateNaturalClient {
    private ClientPort clientPort;

    public void createNaturalClient(Client client) throws BusinessException {
        if (clientPort.existsByDocument(client.getDocument())) {
            throw new BusinessException("There is already a client with that document.");
        }
        if (clientPort.existsByEmail(client.getEmail())) {
            throw new BusinessException("There is already a client with that email.");
        }

        client.setClientRole(ClientRole.NATURALCLIENT);
        clientPort.saveClient(client);
    }
}
