package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.AccountRequest;
import bankapp.application.adapters.api.response.AccountResponse;
import bankapp.domain.models.Account;
import bankapp.domain.models.AccountState;
import bankapp.domain.services.CreateAccount;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/accounts")
@Getter
@Setter

public class AccountController {
    
    private CreateAccount createAccount;

    @PostMapping
    public AccountResponse createAccount(@RequestBody AccountRequest request) {
        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setAccountType(request.getAccountType());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setCurrencyType(request.getCurrencyType());
        account.setAccountState(AccountState.ACTIVEACCOUNT);

        createAccount.createAccount(account);

        AccountResponse response = new AccountResponse();
        response.setId(account.getAccountId());
        response.setAccountNumber(account.getAccountNumber());
        response.setAccountType(account.getAccountType());
        response.setCurrentBalance(account.getCurrentBalance());
        response.setCurrencyType(account.getCurrencyType());
        response.setAccountState(account.getAccountState());
        response.setOpeningDate(account.getOpeningDate());

        return response;
    }
}