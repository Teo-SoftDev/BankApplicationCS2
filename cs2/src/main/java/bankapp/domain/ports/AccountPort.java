package bankapp.domain.ports;

import bankapp.domain.models.Account;
import bankapp.domain.models.AccountState;

public interface AccountPort {

    public boolean existsByAccountNumber(String accountNumber);
    
    public void saveAccount(Account account);
    public void updateAccountBalance(Account account);
    public void updateAccountState(Account account);
    public Account findAccountByAccountNumber(String accountNumber);

}