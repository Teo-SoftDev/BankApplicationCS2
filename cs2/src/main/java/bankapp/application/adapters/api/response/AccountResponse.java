package bankapp.application.adapters.api.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import bankapp.domain.models.AccountState;
import bankapp.domain.models.AccountType;
import bankapp.domain.models.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private Long id;
    private String accountNumber;
    private String productName;
    private AccountType accountType;
    private String holderName;
    private BigDecimal currentBalance;
    private Currency currencyType;
    private AccountState accountState;
    private LocalDate openingDate;

    public static AccountResponse fromAccount(bankapp.domain.models.Account account) {
        AccountResponse response = new AccountResponse();
        response.setId(account.getAccountId());
        response.setAccountNumber(account.getAccountNumber());
        response.setProductName(account.getProductName());
        response.setAccountType(account.getAccountType());
        response.setCurrentBalance(account.getCurrentBalance());
        response.setCurrencyType(account.getCurrencyType());
        response.setAccountState(account.getAccountState());
        response.setOpeningDate(account.getOpeningDate());
        if (account.getHolder() != null) {
            response.setHolderName(account.getHolder().getName());
        }
        return response;
    }
}
