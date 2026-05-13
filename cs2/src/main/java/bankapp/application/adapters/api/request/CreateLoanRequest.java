package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

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
    private int termInMonths;

    public static bankapp.domain.models.Loan toEntity(CreateLoanRequest request) {
        bankapp.domain.models.Loan loan = new bankapp.domain.models.Loan();
        loan.setLoanType(request.getLoanType());
        loan.setRequestedAmount(request.getRequestedAmount());
        loan.setInterestRate(request.getInterestRate());
        loan.setTermInMonths(request.getTermInMonths());
        return loan;
    }
}
