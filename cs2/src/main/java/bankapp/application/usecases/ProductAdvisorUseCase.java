package bankapp.application.usecases;

import bankapp.domain.models.Client;

import org.springframework.stereotype.Service;

import bankapp.domain.models.Account;
import bankapp.domain.models.Loan;

import bankapp.domain.services.CreateAccount;
import bankapp.domain.services.FindAccount;
import bankapp.domain.services.CreateLoan;
import bankapp.domain.services.FindLoan;

@Service
public class ProductAdvisorUseCase {
    private final CreateAccount createAccount;
    private final FindAccount findAccount;
    private final CreateLoan createLoan;
    private final FindLoan findLoan;

    public ProductAdvisorUseCase(CreateAccount createAccount, FindAccount findAccount, CreateLoan createLoan, FindLoan findLoan) {
        this.createAccount = createAccount;
        this.findAccount = findAccount;
        this.createLoan = createLoan;
        this.findLoan = findLoan;
    }

    public void createAccount(Client client, Account account) {
        account.setHolder(client);
        createAccount.createAccount(account);
    }

    public Account findAccountByAccountNumber(String accountNumber) throws Exception {
        return findAccount.findByAccountNumber(accountNumber);
    }

    public void createLoan(Client client, Loan loan) throws Exception {
        loan.setRequestingClient(client);
        createLoan.createLoan(loan);
    }

    public Loan findLoanById(long loanId) throws Exception {
        return findLoan.findById(loanId);
    }

}
