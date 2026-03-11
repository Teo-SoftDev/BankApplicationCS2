package bankapp.domain.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor

public class Transfer{
    private long idTransfer;
    private Account OriginAccount;
    private Account DestinationAccount;
    private double amount;
    private Date creationDate;
    private Date approvalDate;
    private LoanState loanState;
}