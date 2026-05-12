package bankapp.domain.ports;

import java.util.List;

import bankapp.domain.models.Client;
import bankapp.domain.models.Loan;

public interface LoanPort {
    // if the loan already exists
    public boolean existsById(long loanId);

    public Loan findById(long loanId);

    public List<Loan> findLoanByClient(Client requestingClient);

    public void saveLoan(Loan loan);
    public void updateLoan(Loan loan);

}