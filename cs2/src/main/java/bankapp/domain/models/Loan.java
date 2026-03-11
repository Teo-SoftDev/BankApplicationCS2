package bankapp.domain.models;

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
    private double requestedAmount;
    private double approvedAmount;
    private double interestRate;
    private int termInMonths;
    private LoanState loanState;
    private Date approvalDate;
    private Date disbursementDate;
    private Account destinationAccount;
}
