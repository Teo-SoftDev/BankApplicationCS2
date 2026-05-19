package bankapp.application.adapters.persistence;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import bankapp.domain.ports.AccountPort;
import bankapp.domain.models.Account;
import bankapp.domain.models.AccountState;
import bankapp.domain.models.AccountType;
import bankapp.domain.models.Client;
import bankapp.domain.models.Role;
import bankapp.domain.models.Currency;
import bankapp.application.adapters.persistence.sql.repositories.AccountRepository;
import bankapp.application.adapters.persistence.sql.entities.AccountEntity;
import bankapp.application.adapters.persistence.sql.entities.ClientEntity;

import java.time.LocalDate;

@Service
public class AccountPersistenceAdapter implements AccountPort {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        return accountRepository.existsByAccountNumber(accountNumber);
    }

    @Override
    public void saveAccount(Account account) {
        AccountEntity entity = mapToEntity(account);
        accountRepository.save(entity);
    }

    @Override
    public void updateAccountBalance(Account account) {
        AccountEntity entity = mapToEntity(account);
        accountRepository.save(entity);
    }

    @Override
    public void updateAccountState(Account account) {
        AccountEntity entity = mapToEntity(account);
        accountRepository.save(entity);
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        AccountEntity entity = accountRepository.findByAccountNumber(accountNumber)
            .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNumber));
        return mapToDomain(entity);
    }

    private AccountEntity mapToEntity(Account account) {
        if (account == null) {
            return null;
        }

        AccountEntity entity = new AccountEntity();
        entity.setProductId(account.getProductId());
        entity.setProductName(account.getProductName());
        entity.setApproval(account.isApproval());
        entity.setAccountNumber(account.getAccountNumber());
        entity.setAccountType(account.getAccountType().toString());
        entity.setHolder(mapClientToEntity(account.getHolder()));
        entity.setCurrentBalance(account.getCurrentBalance());
        entity.setCurrencyType(account.getCurrencyType().toString());
        entity.setAccountState(account.getAccountState().toString());
        entity.setOpeningDate(LocalDate.now());
        return entity;
    }

    private Account mapToDomain(AccountEntity entity) {
        if (entity == null) {
            return null;
        }

        Account account = new Account();
        account.setProductId(entity.getProductId());
        account.setProductName(entity.getProductName());
        account.setApproval(entity.isApproval());
        account.setAccountNumber(entity.getAccountNumber());
        account.setAccountType(AccountType.valueOf(entity.getAccountType()));
        account.setHolder(mapClientToDomain(entity.getHolder()));
        account.setCurrentBalance(entity.getCurrentBalance());
        account.setCurrencyType(Currency.valueOf(entity.getCurrencyType()));
        account.setAccountState(AccountState.valueOf(entity.getAccountState()));
        account.setOpeningDate(entity.getOpeningDate());
        return account;
    }

    private ClientEntity mapClientToEntity(Client client) {
        if (client == null) {
            return null;
        }

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

    private Client mapClientToDomain(ClientEntity entity) {
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
