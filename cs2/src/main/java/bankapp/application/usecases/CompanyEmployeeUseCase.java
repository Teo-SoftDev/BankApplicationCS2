package bankapp.application.usecases;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import bankapp.domain.models.Account;
import bankapp.domain.models.Loan;
import bankapp.domain.models.Transfer;
import bankapp.domain.models.TransferState;
import bankapp.domain.services.CreateTransfer;
import bankapp.domain.services.FindAccount;
import bankapp.domain.services.FindTransfer;
import bankapp.domain.services.FindLoan;
import java.time.LocalDate;

@Service
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
        var limit = new BigDecimal("600000");

        transfer.setOriginAccount(originAccount);
        transfer.setDestinationAccount(destinationAccount);
        transfer.setAmount(amount);
        transfer.setCreationDate(LocalDate.now());

        if (transfer.getAmount().compareTo(limit) > 0) {
            transfer.setTransferState(TransferState.PENDING);
        } else {
            transfer.setTransferState(TransferState.COMPLETED);
        }

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
