package bankapp.application.adapters.persistence;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import bankapp.domain.ports.TransferPort;
import bankapp.domain.models.Transfer;
import bankapp.domain.models.Account;
import bankapp.domain.models.Client;
import bankapp.application.adapters.persistence.sql.repositories.TransferRepository;
import bankapp.application.adapters.persistence.sql.entities.TransferEntity;
import bankapp.application.adapters.persistence.sql.entities.AccountEntity;
import bankapp.application.adapters.persistence.sql.entities.ClientEntity;

@Service
public class TransferPersistenceAdapter implements TransferPort {

    @Autowired
    private TransferRepository transferRepository;

    @Override
    public boolean existsById(long transferId) {
        return transferRepository.existsById(Long.valueOf(transferId));
    }

    @Override
    public Transfer findById(long transferId) {
        TransferEntity entity = transferRepository.findById(Long.valueOf(transferId))
            .orElseThrow(() -> new RuntimeException("Transfer not found with id: " + transferId));
        return mapToDomain(entity);
    }

    @Override
    public void saveTransfer(Transfer transfer) {
        TransferEntity entity = mapToEntity(transfer);
        entity = transferRepository.save(entity);
        transfer.setIdTransfer(entity.getIdTransfer());
    }

    @Override
    public void updateTransfer(Transfer transfer) {
        TransferEntity entity = mapToEntity(transfer);
        transferRepository.save(entity);
    }

    private TransferEntity mapToEntity(Transfer transfer) {
        TransferEntity entity = new TransferEntity();
        entity.setIdTransfer(transfer.getIdTransfer());
        entity.setOriginAccount(mapAccountToEntity(transfer.getOriginAccount()));
        entity.setDestinationAccount(mapAccountToEntity(transfer.getDestinationAccount()));
        entity.setAmount(transfer.getAmount());
        entity.setCreationDate(transfer.getCreationDate());
        entity.setApprovalDate(transfer.getApprovalDate());
        entity.setTransferState(transfer.getTransferState());
        return entity;
    }

    private Transfer mapToDomain(TransferEntity entity) {
        Transfer transfer = new Transfer();
        transfer.setIdTransfer(entity.getIdTransfer());
        transfer.setOriginAccount(mapAccountToDomain(entity.getOriginAccount()));
        transfer.setDestinationAccount(mapAccountToDomain(entity.getDestinationAccount()));
        transfer.setAmount(entity.getAmount());
        transfer.setCreationDate(entity.getCreationDate());
        transfer.setApprovalDate(entity.getApprovalDate());
        transfer.setTransferState(entity.getTransferState());
        return transfer;
    }

    private AccountEntity mapAccountToEntity(Account account) {
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

    private Account mapAccountToDomain(AccountEntity entity) {
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
