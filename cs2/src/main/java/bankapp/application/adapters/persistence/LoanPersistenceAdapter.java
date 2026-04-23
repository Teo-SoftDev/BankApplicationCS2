package bankapp.application.adapters.persistence;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;
import bankapp.domain.models.Account;
import bankapp.domain.models.Client;
import bankapp.application.adapters.persistence.sql.repositories.LoanRepository;
import bankapp.application.adapters.persistence.sql.entities.LoanEntity;
import bankapp.application.adapters.persistence.sql.entities.AccountEntity;
import bankapp.application.adapters.persistence.sql.entities.ClientEntity;

@Service
public class LoanPersistenceAdapter implements LoanPort {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public boolean existsById(long loanId) {
        return loanRepository.existsById(Long.valueOf(loanId));
    }

    @Override
    public Loan findById(long loanId) {
        LoanEntity entity = loanRepository.findById(Long.valueOf(loanId))
            .orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanId));
        return mapToDomain(entity);
    }

    @Override
    public void saveLoan(Loan loan) {
        LoanEntity entity = mapToEntity(loan);
        entity = loanRepository.save(entity);
        loan.setLoanId(entity.getLoanId());
    }

    @Override
    public void updateLoan(Loan loan) {
        LoanEntity entity = mapToEntity(loan);
        loanRepository.save(entity);
    }

    private LoanEntity mapToEntity(Loan loan) {
        LoanEntity entity = new LoanEntity();
        entity.setLoanId(loan.getLoanId());
        entity.setProductId(loan.getProductId());
        entity.setProductName(loan.getProductName());
        entity.setProductCategory(loan.getProductCategory());
        entity.setApproval(loan.isApproval());
        entity.setLoanType(loan.getLoanType());
        entity.setRequestingClient(mapClientToEntity(loan.getRequestingClient()));
        entity.setRequestedAmount(loan.getRequestedAmount());
        entity.setApprovedAmount(loan.getApprovedAmount());
        entity.setInterestRate(loan.getInterestRate());
        entity.setTermInMonths(loan.getTermInMonths());
        entity.setLoanState(loan.getLoanState());
        entity.setApprovalDate(loan.getApprovalDate());
        entity.setDisbursementDate(loan.getDisbursementDate());
        entity.setDestinationAccount(mapAccountToEntity(loan.getDestinationAccount()));
        return entity;
    }

    private Loan mapToDomain(LoanEntity entity) {
        Loan loan = new Loan();
        loan.setLoanId(entity.getLoanId());
        loan.setProductId(entity.getProductId());
        loan.setProductName(entity.getProductName());
        loan.setProductCategory(entity.getProductCategory());
        loan.setApproval(entity.isApproval());
        loan.setLoanType(entity.getLoanType());
        loan.setRequestingClient(mapClientToDomain(entity.getRequestingClient()));
        loan.setRequestedAmount(entity.getRequestedAmount());
        loan.setApprovedAmount(entity.getApprovedAmount());
        loan.setInterestRate(entity.getInterestRate());
        loan.setTermInMonths(entity.getTermInMonths());
        loan.setLoanState(entity.getLoanState());
        loan.setApprovalDate(entity.getApprovalDate());
        loan.setDisbursementDate(entity.getDisbursementDate());
        loan.setDestinationAccount(mapAccountToDomain(entity.getDestinationAccount()));
        return loan;
    }

    private AccountEntity mapAccountToEntity(Account account) {
        if (account == null) return null;
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
        if (entity == null) return null;
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
        if (client == null) return null;
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
        if (entity == null) return null;
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
