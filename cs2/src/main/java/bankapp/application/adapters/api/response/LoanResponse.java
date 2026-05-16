package bankapp.application.adapters.api.response;

import java.math.BigDecimal;

import bankapp.domain.models.LoanState;
import bankapp.domain.models.LoanType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {
    private Long id;
    private LoanType loanType;
    private String clientName;
    private BigDecimal requestedAmount;
    private BigDecimal approvedAmount;
    private BigDecimal interestRate;
    private int termInMonths;
    private LoanState loanState;

    public static LoanResponse fromLoan(bankapp.domain.models.Loan loan) {
        LoanResponse response = new LoanResponse();
        response.setId(loan.getLoanId());
        response.setLoanType(loan.getLoanType());
        response.setRequestedAmount(loan.getRequestedAmount());
        response.setApprovedAmount(loan.getApprovedAmount());
        response.setInterestRate(loan.getInterestRate());
        response.setTermInMonths(loan.getTermInMonths());
        response.setLoanState(loan.getLoanState());
        if (loan.getRequestingClient() != null) {
            response.setClientName(loan.getRequestingClient().getName());
        }
        return response;
    }
}
