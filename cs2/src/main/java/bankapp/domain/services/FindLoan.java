package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;

public class FindClient {
    private LoanPort loanPort;

    public Loan findById(long loanId) throws BusinessException {
        Loan loan = loanPort.findById(loanId);

        if (loan == null) {
            throw new BusinessException("There is no loan with that id");
        }

        return loan;
    }
}