package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;
import bankapp.domain.models.Client;

public class CreateUser {
    private LoanPort loanPort;

    public void createLoan(Loan loan) throws BusinessException{

        if (loanPort.existsById(loan.getLoanId())) {
            throw new BusinessException("Loan already exists.");
        }

        if (loan.getRequestingClient() == null){
            throw new BusinessException("That client doesn't exists.");
        }

        if (loan.getDestinationAccount() == null){
            throw new BusinessException("That account doesn't exists.");
        }

        loanPort.saveLoan(loan);
    }
}
