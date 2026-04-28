package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.ClientRequest;
import bankapp.application.adapters.api.response.ClientResponse;
import bankapp.domain.models.Client;
import bankapp.domain.services.CreateClient;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/clients")
@Getter
@Setter

public class ClientController {
    
    private CreateClient createClient;

    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest request) {
        Client client = new Client();
        client.setDocument(request.getDocument());
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        client.setAddress(request.getAddress());
        client.setBirthDate(request.getBirthDate());
        client.setClientRole(request.getClientRole());

        createClient.createClient(client);

        ClientResponse response = new ClientResponse();
        response.setId(client.getId());
        response.setDocument(client.getDocument());
        response.setName(client.getName());
        response.setEmail(client.getEmail());
        response.setPhone(client.getPhone());
        response.setAddress(client.getAddress());
        response.setBirthDate(client.getBirthDate());
        response.setClientRole(client.getClientRole());

        return response;
    }
}