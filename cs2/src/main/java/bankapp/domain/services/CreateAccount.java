package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.AccountPort;
import bankapp.domain.models.Account;

public class CreateAccount {

    private AccountPort accountPort;

    public void createAccount(Account account) throws BusinessException {

        if (accountPort.existsByAccountNumber(account.getAccountNumber())) {
            throw new BusinessException("There is already an account with that account number.");
        }

        accountPort.saveAccount(account);
        
    }
}
