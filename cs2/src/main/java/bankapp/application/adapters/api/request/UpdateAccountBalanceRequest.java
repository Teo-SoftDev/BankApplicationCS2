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
public class UpdateAccountBalanceRequest {
    private String accountNumber;
    private BigDecimal newBalance;
}
