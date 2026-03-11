package bankapp.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class Account extends Product{
    private String accountNumber;
    private AccountType accountType;
    private Client holder;
    private double currentBalance;
    private Currency currencyType;
    private AccountState accountState;
    private Date openingDate;
}
