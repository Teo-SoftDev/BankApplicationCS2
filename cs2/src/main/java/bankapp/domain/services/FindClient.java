package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.ClientPort;
import bankapp.domain.models.Client;

public class FindClient {
    private ClientPort clientPort;

    public Client findByDocument(String document) throws BusinessException {
        Client client = clientPort.findByDocument(document);

        if (client == null) {
            throw new BusinessException("There is no client with that document");
        }

        return client;
    }
}
