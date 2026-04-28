package bankapp.application.adapters.api.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import bankapp.domain.models.TransferState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class TransferResponse {
    private long id;
    private Long originAccountId;
    private String originAccountNumber;
    private Long destinationAccountId;
    private String destinationAccountNumber;
    private BigDecimal amount;
    private LocalDate creationDate;
    private LocalDate approvalDate;
    private TransferState transferState;
}