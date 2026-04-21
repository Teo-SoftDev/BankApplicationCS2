package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;
import bankapp.domain.models.LoanState;

public class ApproveLoan {
    private LoanPort loanPort;

    public void approveLoan(long loanId) throws BusinessException {
        Loan loan = loanPort.findById(loanId);

        if (loan == null) {
            throw new BusinessException("There's no loan with that id.");
        }

        if (!loan.getLoanState().equals(LoanState.INSTUDY)) {
            throw new BusinessException("Invalid status.");
        }

        loan.setLoanState(LoanState.APPROVED);

        loanPort.updateLoan(loan);
    }
}
