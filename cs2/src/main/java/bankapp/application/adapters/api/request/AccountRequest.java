package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

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
public class AccountRequest {
    private String accountNumber;
    private AccountType accountType;
    private String clientDocument;
    private BigDecimal currentBalance;
    private Currency currencyType;
    private AccountState accountState;

    public static bankapp.domain.models.Account toEntity(AccountRequest request) {
        bankapp.domain.models.Account account = new bankapp.domain.models.Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setAccountType(request.getAccountType());
        account.setCurrentBalance(request.getCurrentBalance());
        account.setCurrencyType(request.getCurrencyType());
        account.setAccountState(request.getAccountState() != null ? request.getAccountState() : bankapp.domain.models.AccountState.ACTIVEACCOUNT);
        return account;
    }
}