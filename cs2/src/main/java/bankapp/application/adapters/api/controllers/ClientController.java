package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.ClientRequest;
import bankapp.application.adapters.api.response.ClientResponse;
import bankapp.application.usecases.CashierUseCase;
import bankapp.domain.models.Client;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    
    private CashierUseCase cashierUseCase;

    @PostMapping("/natural")
    public ClientResponse createNaturalClient(@RequestBody ClientRequest request) throws Exception {
        Client client = ClientRequest.toEntity(request);
        cashierUseCase.createNaturalClient(client);
        return ClientResponse.fromClient(client);
    }

    @PostMapping("/business")
    public ClientResponse createBusinessClient(@RequestBody ClientRequest request) throws Exception {
        Client client = ClientRequest.toEntity(request);
        cashierUseCase.createBusinessClient(client);
        return ClientResponse.fromClient(client);
    }
}