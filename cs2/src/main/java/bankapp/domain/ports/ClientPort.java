package bankapp.domain.ports;

import bankapp.domain.models.Client;

public interface ClientPort {
    // if the client already exists
    public boolean existsByDocument(String document);
    public boolean existsByEmail(String email);

    // CRUD
    public void saveClient(Client client);
    public void updateClient(Client client);
    public Client findByDocument(Client client);
    public void deleteClient(Client client);
}
