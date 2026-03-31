package bankapp.domain.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor

public class Loan extends Product{
    private long loanId;
    private LoanType loanType;
    private Client requestingClient;
    private BigDecimal requestedAmount;
    private BigDecimal approvedAmount;
    private BigDecimal interestRate;
    private int termInMonths;
    private LoanState loanState;
    private Date approvalDate;
    private Date disbursementDate;
    private Account destinationAccount;
}
