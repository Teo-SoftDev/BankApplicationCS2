package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Client;
import bankapp.domain.ports.ClientPort;

@Service
public class UpdateClient {
    private final ClientPort clientPort;

    public UpdateClient(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

    public void updateClient(Client client) throws BusinessException {
        if (!clientPort.existsByDocument(client.getDocument())) {
            throw new BusinessException("There is no client with that document.");
        }

        clientPort.updateClient(client);
    }
}