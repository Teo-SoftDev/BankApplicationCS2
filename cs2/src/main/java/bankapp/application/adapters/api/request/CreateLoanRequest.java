package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

import bankapp.application.adapters.persistence.sql.repositories.AccountRepository;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Account;
import bankapp.domain.models.LoanType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanRequest {
    private LoanType loanType;
    private String clientDocument;
    private BigDecimal requestedAmount;
    private BigDecimal interestRate;
    private Account destinationAccount;
    private int termInMonths;

    public static bankapp.domain.models.Loan toEntity(CreateLoanRequest request) {
        bankapp.domain.models.Loan loan = new bankapp.domain.models.Loan();
        loan.setLoanType(request.getLoanType());
        loan.setRequestedAmount(request.getRequestedAmount());
        loan.setInterestRate(request.getInterestRate());
        Account account = accountRepository
            .findByAccountNumber(
                request.getDestinationAccount().getAccountNumber()
            )
            .orElseThrow(() -> 
                new BusinessException("That account doesn't exists."));
        loan.setTermInMonths(request.getTermInMonths());
        return loan;
    }
}
