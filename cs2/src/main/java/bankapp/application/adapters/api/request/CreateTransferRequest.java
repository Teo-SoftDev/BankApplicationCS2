package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import bankapp.domain.models.Account;
import bankapp.domain.models.Transfer;
import bankapp.domain.models.TransferState;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransferRequest {
    private String originAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal amount;

    public static Transfer toEntity(CreateTransferRequest request) {
        Transfer transfer = new Transfer();
        transfer.setAmount(request.getAmount());
        
        return transfer;
    }
}
