package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.AccountRequest;
import bankapp.application.adapters.api.response.AccountResponse;
import bankapp.application.usecases.ProductAdvisorUseCase;
import bankapp.domain.models.Account;
import bankapp.domain.models.AccountState;
import bankapp.domain.models.Client;
import bankapp.domain.services.FindClient;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {
    
    private ProductAdvisorUseCase productAdvisorUseCase;
    private FindClient findClient;

    @PostMapping
    public AccountResponse createAccount(@RequestBody AccountRequest request) throws Exception {
        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setAccountType(request.getAccountType());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setCurrencyType(request.getCurrencyType());
        account.setAccountState(AccountState.ACTIVEACCOUNT);

        // Find client by document if provided
        Client client = request.getClientDocument() != null ? 
            findClient.findByDocument(request.getClientDocument()) : null;

        productAdvisorUseCase.createAccount(client, account);

        return AccountResponse.fromAccount(account);
    }
}