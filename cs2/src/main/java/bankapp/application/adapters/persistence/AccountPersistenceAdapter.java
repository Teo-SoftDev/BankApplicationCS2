package bankapp.application.adapters.persistence;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import bankapp.domain.ports.AccountPort;
import bankapp.domain.models.Account;
import bankapp.domain.models.Client;
import bankapp.application.adapters.persistence.sql.repositories.AccountRepository;
import bankapp.application.adapters.persistence.sql.entities.AccountEntity;
import bankapp.application.adapters.persistence.sql.entities.ClientEntity;

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
        entity.setProductCategory(account.getProductCategory());
        entity.setApproval(account.isApproval());
        entity.setAccountNumber(account.getAccountNumber());
        entity.setAccountType(account.getAccountType());
        entity.setHolder(mapClientToEntity(account.getHolder()));
        entity.setCurrentBalance(account.getCurrentBalance());
        entity.setCurrencyType(account.getCurrencyType());
        entity.setAccountState(account.getAccountState());
        entity.setOpeningDate(account.getOpeningDate());
        return entity;
    }

    private Account mapToDomain(AccountEntity entity) {
        if (entity == null) {
            return null;
        }

        Account account = new Account();
        account.setProductId(entity.getProductId());
        account.setProductName(entity.getProductName());
        account.setProductCategory(entity.getProductCategory());
        account.setApproval(entity.isApproval());
        account.setAccountNumber(entity.getAccountNumber());
        account.setAccountType(entity.getAccountType());
        account.setHolder(mapClientToDomain(entity.getHolder()));
        account.setCurrentBalance(entity.getCurrentBalance());
        account.setCurrencyType(entity.getCurrencyType());
        account.setAccountState(entity.getAccountState());
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
        entity.setClientRole(client.getClientRole());
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
        client.setClientRole(entity.getClientRole());
        return client;
    }
}
