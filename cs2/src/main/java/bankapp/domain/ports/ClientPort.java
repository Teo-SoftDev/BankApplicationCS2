package bankapp.domain.ports;

import bankapp.domain.models.Client;

public interface ClientPort {
    public boolean existsByDocument(String document);
    public void saveClient(Client client);
    public Client findByDocument(Client client);
}
