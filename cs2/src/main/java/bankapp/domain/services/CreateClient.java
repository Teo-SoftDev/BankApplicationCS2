package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.ClientPort;
import bankapp.domain.models.Client;

@Service
public class CreateClient {

    private final ClientPort clientPort;

    public CreateClient(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

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
