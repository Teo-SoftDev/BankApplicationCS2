package bankapp.application.adapters.api.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import bankapp.domain.models.AccountState;
import bankapp.domain.models.AccountType;
import bankapp.domain.models.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class AccountResponse {
    private long id;
    private String accountNumber;
    private AccountType accountType;
    private Long holderId;
    private String holderName;
    private BigDecimal currentBalance;
    private Currency currencyType;
    private AccountState accountState;
    private LocalDate openingDate;
}