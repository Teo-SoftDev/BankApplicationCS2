package bankapp.domain.ports;

import java.math.BigDecimal;

import bankapp.domain.models.Account;
import bankapp.domain.models.AccountState;

public interface AccountPort {

    public boolean existsByAccountNumber(String accountNumber);
    
    public void saveAccount(Account account);
    public void updateBalance(BigDecimal balance);
    public void updateAccountState(String accountNumber, AccountState accountState);
    public Account findAccountByAccountNumber(String accountNumber);

}