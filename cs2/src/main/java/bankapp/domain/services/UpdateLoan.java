package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;

@Service
public class UpdateLoan {
    private final LoanPort loanPort;

    public UpdateLoan(LoanPort loanPort) {
        this.loanPort = loanPort;
    }

    public void updateLoan(Loan loan) throws BusinessException {
        if (!loanPort.existsById(loan.getLoanId())) {
            throw new BusinessException("There's no loan with that id.");
        }

        loanPort.updateLoan(loan);
    }
}
