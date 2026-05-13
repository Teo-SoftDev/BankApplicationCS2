package bankapp.application.usecases;

import bankapp.domain.services.FindClient;
import bankapp.domain.services.FindAccount;
import bankapp.domain.services.FindLoan;
import bankapp.domain.services.FindTransfer;
import bankapp.domain.services.ApproveLoan;
import bankapp.domain.services.ApproveTransfer;

import bankapp.domain.models.Client;
import bankapp.domain.models.Account;
import bankapp.domain.models.Loan;
import bankapp.domain.models.Transfer;
import bankapp.domain.models.User;

import java.util.List;

public class BackOfficeUseCase {
    private final FindClient findClient;
    private final FindAccount findAccount;
    private final FindLoan findLoan;
    private final FindTransfer findTransfer;
    private final ApproveLoan approveLoan;
    private final ApproveTransfer approveTransfer;

    public BackOfficeUseCase(FindClient findClient, FindAccount findAccount, FindLoan findLoan, FindTransfer findTransfer, ApproveLoan approveLoan, ApproveTransfer approveTransfer) {
        this.findClient = findClient;
        this.findAccount = findAccount;
        this.findLoan = findLoan;
        this.findTransfer = findTransfer;
        this.approveLoan = approveLoan;
        this.approveTransfer = approveTransfer;
    }

    public Client findClientByDocument(String document) throws Exception {
        return findClient.findByDocument(document);
    }

    public Account findAccountByAccountNumber(String accountNumber) throws Exception {
        return findAccount.findByAccountNumber(accountNumber);
    }

    public Loan findLoanById(long loanId) throws Exception {
        return findLoan.findById(loanId);
    }

    public List<Loan> findLoanByClient(String document, User user) throws Exception {
        return findLoan.findLoanByClient(document, user);
    }

    public Transfer findTransferById(long transferId) throws Exception {
        return findTransfer.findById(transferId);
    }

    public List<Transfer> findTransferByClient(String document, User user) throws Exception {
        return findTransfer.findTransferByClient(document, user);
    }

    public void approveLoan(long loanId) throws Exception {
        approveLoan.approveLoan(loanId);
    }

    public void approveTransfer(long transferId) throws Exception {
        approveTransfer.approveTransfer(transferId);
    }
}
