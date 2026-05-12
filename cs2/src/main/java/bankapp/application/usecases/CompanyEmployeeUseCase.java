package bankapp.application.usecases;

import java.math.BigDecimal;

import bankapp.domain.models.Account;
import bankapp.domain.models.Loan;
import bankapp.domain.models.Transfer;

import bankapp.domain.services.CreateTransfer;
import bankapp.domain.services.FindAccount;
import bankapp.domain.services.FindTransfer;
import bankapp.domain.services.FindLoan;

public class CompanyEmployeeUseCase {
    private final CreateTransfer createTransfer;
    private final FindAccount findAccount;
    private final FindTransfer findTransfer;
    private final FindLoan findLoan;

    public CompanyEmployeeUseCase(CreateTransfer createTransfer, FindAccount findAccount, FindTransfer findTransfer, FindLoan findLoan) {
        this.createTransfer = createTransfer;
        this.findAccount = findAccount;
        this.findTransfer = findTransfer;
        this.findLoan = findLoan;
    }

    public void createTransfer(String originAccountNumber, String destinationAccountNumber, BigDecimal amount) throws Exception {
        var originAccount = findAccount.findByAccountNumber(originAccountNumber);
        var destinationAccount = findAccount.findByAccountNumber(destinationAccountNumber);
        var transfer = new bankapp.domain.models.Transfer();
        transfer.setOriginAccount(originAccount);
        transfer.setDestinationAccount(destinationAccount);
        transfer.setAmount(amount);
        createTransfer.createTransfer(transfer);
    }

    public Account findAccountByAccountNumber(String accountNumber) throws Exception {
        return findAccount.findByAccountNumber(accountNumber);
    }

    public Transfer findTransferById(long transferId) throws Exception {
        return findTransfer.findById(transferId);
    }

    public Loan findLoanById(long loanId) throws Exception {
        return findLoan.findById(loanId);
    }

}
