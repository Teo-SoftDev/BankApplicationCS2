package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.ClientRequest;
import bankapp.application.adapters.api.request.UpdateAccountBalanceRequest;
import bankapp.application.adapters.api.response.AccountResponse;
import bankapp.application.adapters.api.response.ClientResponse;
import bankapp.application.usecases.CashierUseCase;
import bankapp.domain.models.Client;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cashier")
@AllArgsConstructor
public class CashierController {
    
    private CashierUseCase cashierUseCase;

    @PostMapping("/clients/natural")
    public ClientResponse createNaturalClient(@RequestBody ClientRequest request) throws Exception {
        Client client = ClientRequest.toEntity(request);
        cashierUseCase.createNaturalClient(client);
        return ClientResponse.fromClient(client);
    }

    @PostMapping("/clients/business")
    public ClientResponse createBusinessClient(@RequestBody ClientRequest request) throws Exception {
        Client client = ClientRequest.toEntity(request);
        cashierUseCase.createBusinessClient(client);
        return ClientResponse.fromClient(client);
    }

    @GetMapping("/clients/{document}")
    public ClientResponse findClientByDocument(@PathVariable String document) throws Exception {
        var client = cashierUseCase.findClientByDocument(document);
        return ClientResponse.fromClient(client);
    }

    @GetMapping("/accounts/{accountNumber}")
    public AccountResponse findAccountByAccountNumber(@PathVariable String accountNumber) throws Exception {
        var account = cashierUseCase.findAccountByAccountNumber(accountNumber);
        return AccountResponse.fromAccount(account);
    }

    @PostMapping("/accounts/update-balance")
    public void updateAccountBalance(@RequestBody UpdateAccountBalanceRequest request) throws Exception {
        cashierUseCase.updateAccountBalance(request.getAccountNumber(), request.getNewBalance());
    }
}
