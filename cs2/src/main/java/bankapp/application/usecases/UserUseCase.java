package bankapp.application.usecases;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Loan;
import bankapp.domain.models.User;
import bankapp.domain.services.CreateLoan;
import bankapp.domain.services.CreateTransfer;
import bankapp.domain.services.FindLoan;
import bankapp.domain.services.FindTransfer;

public class UserUseCase {
    private final CreateLoan createLoan;
    private final FindLoan findLoan;
    private final CreateTransfer createTransfer;
    private final FindTransfer findTransfer;

    public UserUseCase(CreateLoan createLoan, FindLoan findLoan, CreateTransfer createTransfer, FindTransfer findTransfer) {
        this.createLoan = createLoan;
        this.findLoan = findLoan;
        this.createTransfer = createTransfer;
        this.findTransfer = findTransfer;
    }

    public void createLoan(User user, Loan loan) throws BusinessException {
        loan.set
    }
}
