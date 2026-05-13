package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Client;
import bankapp.domain.models.Role;
import bankapp.domain.ports.ClientPort;

@Service
public class CreateBusinessClient {
    private final ClientPort clientPort;

    public CreateBusinessClient(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

    public void createBusinessClient(Client client) throws BusinessException {
        if(clientPort.existsByDocument(client.getDocument())) {
            throw new BusinessException("There is already a client with that document.");
        }
        client.setRole(Role.BUSINESSCLIENT);
        clientPort.saveClient(client);
    }
}
