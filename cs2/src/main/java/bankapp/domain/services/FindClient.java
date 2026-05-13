package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.ClientPort;
import bankapp.domain.models.Client;

@Service
public class FindClient {
    private final ClientPort clientPort;

    public FindClient(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

    public Client findByDocument(String document) throws BusinessException {
        Client client = clientPort.findByDocument(document);

        if (client == null) {
            throw new BusinessException("There is no client with that document");
        }

        return client;
    }
}
