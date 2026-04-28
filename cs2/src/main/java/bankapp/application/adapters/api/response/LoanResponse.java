package bankapp.application.adapters.api.response;

import java.math.BigDecimal;
import java.util.Date;

import bankapp.domain.models.LoanState;
import bankapp.domain.models.LoanType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class LoanResponse {
    private long id;
    private LoanType loanType;
    private Long requestingClientId;
    private String requestingClientName;
    private BigDecimal requestedAmount;
    private BigDecimal approvedAmount;
    private BigDecimal interestRate;
    private int termInMonths;
    private LoanState loanState;
    private Date approvalDate;
    private Date disbursementDate;
    private Long destinationAccountId;
}