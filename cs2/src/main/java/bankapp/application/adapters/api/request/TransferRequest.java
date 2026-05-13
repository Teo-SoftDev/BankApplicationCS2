package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {
    private String originAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal amount;

    public static bankapp.domain.models.Transfer toEntity(TransferRequest request) {
        bankapp.domain.models.Transfer transfer = new bankapp.domain.models.Transfer();
        transfer.setAmount(request.getAmount());
        transfer.setTransferState(bankapp.domain.models.TransferState.PENDING);
        return transfer;
    }
}