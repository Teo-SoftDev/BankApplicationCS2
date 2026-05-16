package bankapp.application.adapters.api.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import bankapp.domain.models.TransferState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponse {
    private Long id;
    private String originAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal amount;
    private LocalDate creationDate;
    private TransferState transferState;

    public static TransferResponse fromTransfer(bankapp.domain.models.Transfer transfer) {
        TransferResponse response = new TransferResponse();
        response.setId(transfer.getIdTransfer());
        response.setAmount(transfer.getAmount());
        response.setCreationDate(transfer.getCreationDate());
        response.setTransferState(transfer.getTransferState());
        if (transfer.getOriginAccount() != null) {
            response.setOriginAccountNumber(transfer.getOriginAccount().getAccountNumber());
        }
        if (transfer.getDestinationAccount() != null) {
            response.setDestinationAccountNumber(transfer.getDestinationAccount().getAccountNumber());
        }
        return response;
    }
}
