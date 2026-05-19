package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;

@Service
public class CreateLoan {
    private final LoanPort loanPort;

    public CreateLoan(LoanPort loanPort) {
        this.loanPort = loanPort;
    }

    public void createLoan(Loan loan) throws BusinessException{

        if (loan.getRequestingClient() == null){
            throw new BusinessException("That client doesn't exists.");
        }

        if (loan.getDestinationAccount() == null){
            throw new BusinessException("That account doesn't exists.");
        }

        loanPort.saveLoan(loan);
    }
}
