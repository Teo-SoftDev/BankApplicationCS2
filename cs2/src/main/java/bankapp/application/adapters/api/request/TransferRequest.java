package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class TransferRequest {
    private Long originAccountId;
    private Long destinationAccountId;
    private BigDecimal amount;
}