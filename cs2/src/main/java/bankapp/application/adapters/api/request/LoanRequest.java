package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

import bankapp.domain.models.LoanType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class LoanRequest {
    private LoanType loanType;
    private Long requestingClientId;
    private BigDecimal requestedAmount;
    private BigDecimal interestRate;
    private int termInMonths;
    private Long destinationAccountId;
}