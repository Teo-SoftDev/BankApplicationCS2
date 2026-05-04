package bankapp.application.adapters.persistence;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;
import bankapp.domain.models.LoanState;
import bankapp.domain.models.LoanType;
import bankapp.domain.models.ProdCategory;
import bankapp.domain.models.Role;
import bankapp.domain.models.Account;
import bankapp.domain.models.AccountState;
import bankapp.domain.models.AccountType;
import bankapp.domain.models.Client;
import bankapp.domain.models.ClientRole;
import bankapp.domain.models.Currency;
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
        if (loan == null) {
            return null;
        }
        LoanEntity entity = new LoanEntity();
        entity.setLoanId(loan.getLoanId());
        entity.setProductId(loan.getProductId());
        entity.setProductName(loan.getProductName());
        entity.setProductCategory(loan.getProductCategory().toString());
        entity.setApproval(loan.isApproval());
        entity.setLoanType(loan.getLoanType().toString());
        entity.setRequestingClient(mapClientToEntity(loan.getRequestingClient()));
        entity.setRequestedAmount(loan.getRequestedAmount());
        entity.setApprovedAmount(loan.getApprovedAmount());
        entity.setInterestRate(loan.getInterestRate());
        entity.setTermInMonths(loan.getTermInMonths());
        entity.setLoanState(loan.getLoanState().toString());
        entity.setApprovalDate(loan.getApprovalDate());
        entity.setDisbursementDate(loan.getDisbursementDate());
        entity.setDestinationAccount(mapAccountToEntity(loan.getDestinationAccount()));
        return entity;
    }

    private Loan mapToDomain(LoanEntity entity) {
        if (entity == null) return null;
        Loan loan = new Loan();
        loan.setLoanId(entity.getLoanId());
        loan.setProductId(entity.getProductId());
        loan.setProductName(entity.getProductName());
        loan.setProductCategory(ProdCategory.valueOf(entity.getProductCategory()));
        loan.setApproval(entity.isApproval());
        loan.setLoanType(LoanType.valueOf(entity.getLoanType()));
        loan.setRequestingClient(mapClientToDomain(entity.getRequestingClient()));
        loan.setRequestedAmount(entity.getRequestedAmount());
        loan.setApprovedAmount(entity.getApprovedAmount());
        loan.setInterestRate(entity.getInterestRate());
        loan.setTermInMonths(entity.getTermInMonths());
        loan.setLoanState(LoanState.valueOf(entity.getLoanState()));
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
        entity.setProductCategory(account.getProductCategory().toString());
        entity.setApproval(account.isApproval());
        entity.setAccountNumber(account.getAccountNumber());
        entity.setAccountType(account.getAccountType().toString());
        entity.setHolder(mapClientToEntity(account.getHolder()));
        entity.setCurrentBalance(account.getCurrentBalance());
        entity.setCurrencyType(account.getCurrencyType().toString());
        entity.setAccountState(account.getAccountState().toString());
        entity.setOpeningDate(account.getOpeningDate());
        return entity;
    }

    private Account mapAccountToDomain(AccountEntity entity) {
        if (entity == null) return null;
        Account account = new Account();
        account.setProductId(entity.getProductId());
        account.setProductName(entity.getProductName());
        account.setProductCategory(ProdCategory.valueOf(entity.getProductCategory()));
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
        if (client == null) return null;
        ClientEntity entity = new ClientEntity();
        entity.setId(client.getId());
        entity.setName(client.getName());
        entity.setDocument(client.getDocument());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
        entity.setBirthDate(client.getBirthDate());
        entity.setAddress(client.getAddress());
        entity.setClientRole(client.getClientRole().toString());
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
        client.setClientRole(ClientRole.valueOf(entity.getClientRole()));
        return client;
    }
}
