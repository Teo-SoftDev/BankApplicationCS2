package bankapp.application.adapters.persistence;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import bankapp.domain.ports.ClientPort;
import bankapp.domain.models.Client;
import bankapp.domain.models.Role;
import bankapp.application.adapters.persistence.sql.repositories.ClientRepository;
import bankapp.application.adapters.persistence.sql.entities.ClientEntity;

@Service
public class ClientPersistenceAdapter implements ClientPort {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public boolean existsByDocument(String document) {
        return clientRepository.existsByDocument(document);
    }

    @Override
    public boolean existsByEmail(String email) {
        return clientRepository.existsByEmail(email);
    }

    @Override
    public void saveClient(Client client) {
        ClientEntity entity = mapToEntity(client);
        clientRepository.save(entity);
        // Update the client ID if it was generated
        client.setId(entity.getId());
    }

    @Override
    public void updateClient(Client client) {
        ClientEntity entity = mapToEntity(client);
        clientRepository.save(entity);
    }

    @Override
    public Client findByDocument(String document) {
        ClientEntity entity = clientRepository.findByDocument(document)
            .orElseThrow(() -> new RuntimeException("Client not found with document: " + document));
        return mapToDomain(entity);
    }

    @Override
    public void deleteClient(String document) {
        clientRepository.deleteByDocument(document);
    }

    private ClientEntity mapToEntity(Client client) {
        ClientEntity entity = new ClientEntity();
        entity.setId(client.getId());
        entity.setName(client.getName());
        entity.setDocument(client.getDocument());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
        entity.setBirthDate(client.getBirthDate());
        entity.setAddress(client.getAddress());
        entity.setRole(client.getRole().toString());
        return entity;
    }

    private Client mapToDomain(ClientEntity entity) {
        if (entity == null) {
            return null;
        }
        Client client = new Client();
        client.setId(entity.getId());
        client.setName(entity.getName());
        client.setDocument(entity.getDocument());
        client.setEmail(entity.getEmail());
        client.setPhone(entity.getPhone());
        client.setBirthDate(entity.getBirthDate());
        client.setAddress(entity.getAddress());
        client.setRole(Role.valueOf(entity.getRole()));
        return client;
    }
}