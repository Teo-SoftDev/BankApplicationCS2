package bankapp.application.usecases;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import bankapp.domain.models.Client;
import bankapp.domain.models.Account;

import bankapp.domain.services.CreateBusinessClient;
import bankapp.domain.services.CreateNaturalClient;
import bankapp.domain.services.FindAccount;
import bankapp.domain.services.FindClient;
import bankapp.domain.services.UpdateAccountBalance;

@Service
public class CashierUseCase {
    private final CreateNaturalClient createNaturalClient;
    private final CreateBusinessClient createBusinessClient;
    private final FindClient findClient;
    private final FindAccount findAccount;
    private final UpdateAccountBalance updateAccountBalance;

    public CashierUseCase(CreateNaturalClient createNaturalClient, CreateBusinessClient createBusinessClient, FindClient findClient, FindAccount findAccount, UpdateAccountBalance updateAccountBalance) {
        this.createNaturalClient = createNaturalClient;
        this.createBusinessClient = createBusinessClient;
        this.findClient = findClient;
        this.findAccount = findAccount;
        this.updateAccountBalance = updateAccountBalance;
    }

    public void createNaturalClient(Client client) {
        createNaturalClient.createNaturalClient(client);
    }

    public void createBusinessClient(Client client) {
        createBusinessClient.createBusinessClient(client);
    }

    public Client findClientByDocument(String document) throws Exception {
        return findClient.findByDocument(document);
    }

    public Account findAccountByAccountNumber(String accountNumber) throws Exception {
        return findAccount.findByAccountNumber(accountNumber);
    }

    public void updateAccountBalance(String accountNumber, BigDecimal newBalance) throws Exception {
        updateAccountBalance.updateAccountBalance(accountNumber, newBalance);
    }


}
