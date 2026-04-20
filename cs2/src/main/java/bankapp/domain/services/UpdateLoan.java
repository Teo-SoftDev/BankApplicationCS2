package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;

public class UpdateLoan {
    private LoanPort loanPort;

    public void updateLoan(Loan loan) throws BusinessException {
        if (!loanPort.existsById(loan.getLoanId())) {
            throw new BusinessException("There's no loan with that id.");
        }

        loanPort.updateLoan(loan);
    }
}
