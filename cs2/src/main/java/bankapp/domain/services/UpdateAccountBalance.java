package bankapp.domain.services;

import java.math.BigDecimal;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Account;
import bankapp.domain.ports.AccountPort;

public class UpdateAccountBalance {
    
    private AccountPort accountPort;

    public void updateAccountBalance(String accountNumber, BigDecimal balance) throws BusinessException {

        Account account = accountPort.findAccountByAccountNumber(accountNumber);

        if(account == null){
            throw new BusinessException("There is no an account with that account number");
        }

        account.setCurrentBalance(balance);
        accountPort.updateAccountBalance(account);
    }
}
