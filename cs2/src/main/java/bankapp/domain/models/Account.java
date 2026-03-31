package bankapp.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class Account extends Product{
    private String accountNumber;
    private AccountType accountType;
    private Client holder;
    private BigDecimal currentBalance;
    private Currency currencyType;
    private AccountState accountState;
    private LocalDate openingDate;
}
