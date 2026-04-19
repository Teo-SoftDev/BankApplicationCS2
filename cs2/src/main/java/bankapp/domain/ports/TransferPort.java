package bankapp.domain.ports;

import bankapp.domain.models.Transfer;

public interface LoanPort {
    // if the loan already exists
    public boolean existsById(long transferId);

    public Loan findById(long transferId);

    public void saveLoan(Transfer transfer);
    public void updateLoan(Transfer transfer);

}