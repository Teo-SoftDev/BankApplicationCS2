package bankapp.application.usecases;

import bankapp.domain.Exceptions.BusinessException;
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

}
