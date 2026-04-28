package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

import bankapp.domain.models.AccountState;
import bankapp.domain.models.AccountType;
import bankapp.domain.models.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class AccountRequest {
    private String accountNumber;
    private AccountType accountType;
    private Long holderId;
    private BigDecimal currentBalance;
    private Currency currencyType;
    private AccountState accountState;
}