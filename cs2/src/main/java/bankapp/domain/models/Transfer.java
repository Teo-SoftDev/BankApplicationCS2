package bankapp.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor

public class Transfer{
    private Long idTransfer;
    private Account originAccount;
    private Account destinationAccount;
    private BigDecimal amount;
    private LocalDate creationDate;
    private LocalDate approvalDate;
    private TransferState transferState;
}