package bankapp.application.usecases;

import bankapp.domain.Exceptions.BusinessException;

import java.util.List;
import bankapp.domain.models.Client;
import bankapp.domain.models.Loan;
import bankapp.domain.models.User;
import bankapp.domain.services.ApproveLoan;
import bankapp.domain.services.ApproveTransfer;
import bankapp.domain.services.FindLoan;

public class CompanySupervisorUseCase {
    private final ApproveLoan approveLoan;
    private final ApproveTransfer approveTransfer;
    private final FindLoan findLoan;

    public CompanySupervisorUseCase(ApproveLoan approveLoan, ApproveTransfer approveTransfer, FindLoan findLoan) {
        this.approveLoan = approveLoan;
        this.approveTransfer = approveTransfer;
        this.findLoan = findLoan;
    }

    public void approveLoan(long loanId) throws BusinessException {
        approveLoan.approveLoan(loanId);
    }

    public void approveTransfer(long idTransfer) throws BusinessException {
        approveTransfer.approveTransfer(idTransfer);
    }

    public  List<Loan> findLoanByClient(String document, User user) throws BusinessException {
        return findLoan.findLoanByClient(document, user);
    }

}
