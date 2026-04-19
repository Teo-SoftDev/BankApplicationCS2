package bankapp.domain.ports;

import bankapp.domain.models.Loan;

public interface LoanPort {
    // if the loan already exists
    public boolean existsById(long loanId);

    public Loan findById(long loanId);

    public void saveLoan(Loan loan);
    public void updateLoan(Loan loan);

}