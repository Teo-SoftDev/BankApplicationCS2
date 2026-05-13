package bankapp.domain.services;

import bankapp.domain.ports.ClientPort;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Client;
import bankapp.domain.models.Role;

@Service
public class CreateNaturalClient {
    private final ClientPort clientPort;

    public CreateNaturalClient(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

    public void createNaturalClient(Client client) throws BusinessException {
        if (clientPort.existsByDocument(client.getDocument())) {
            throw new BusinessException("There is already a client with that document.");
        }
        if (clientPort.existsByEmail(client.getEmail())) {
            throw new BusinessException("There is already a client with that email.");
        }

        client.setRole(Role.NATURALCLIENT);
        clientPort.saveClient(client);
    }
}
