package bankapp.application.usecases;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Loan;
import bankapp.domain.models.Client;
import bankapp.domain.models.Transfer;
import bankapp.domain.models.Account;

import bankapp.domain.services.CreateLoan;
import bankapp.domain.services.CreateTransfer;
import bankapp.domain.services.FindLoan;
import bankapp.domain.services.FindTransfer;
import bankapp.domain.services.FindAccount;

@Service
public class UserUseCase {
    private final CreateLoan createLoan;
    private final FindLoan findLoan;
    private final CreateTransfer createTransfer;
    private final FindTransfer findTransfer;
    private final FindAccount findAccount;

    public UserUseCase(CreateLoan createLoan, FindLoan findLoan, CreateTransfer createTransfer, FindTransfer findTransfer, FindAccount findAccount) {
        this.createLoan = createLoan;
        this.findLoan = findLoan;
        this.createTransfer = createTransfer;
        this.findTransfer = findTransfer;
        this.findAccount = findAccount;
    }

    public void createLoan(Client client, Loan loan) throws BusinessException {
        loan.setRequestingClient(client);
        createLoan.createLoan(loan);
    }

    public Loan findLoanById(long loanId) throws BusinessException {
        return findLoan.findById(loanId);
    }

    public void createTransfer(Account account, Transfer transfer) throws BusinessException {
        transfer.setOriginAccount(account);
        createTransfer.createTransfer(transfer);
    }

    public Transfer findTransferById(long transferId) throws BusinessException {
        return findTransfer.findById(transferId);
    }

    public Account findAccountByAccountNumber(String accountNumber) throws BusinessException {
        return findAccount.findByAccountNumber(accountNumber);
    }
}
