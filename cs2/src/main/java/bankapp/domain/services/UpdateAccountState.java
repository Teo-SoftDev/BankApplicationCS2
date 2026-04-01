package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Account;
import bankapp.domain.ports.AccountPort;
import bankapp.domain.models.AccountState;

public class UpdateAccountState {

    private AccountPort accountPort;

    public void updateAccountState(String accountNumber, AccountState accountState) throws BusinessException {

        Account account = accountPort.findAccountByAccountNumber(accountNumber);

        if(account == null) {
            throw new BusinessException("There is no an account with that account number");
        }

        account.setAccountState(accountState);
        accountPort.updateAccountState(account);
    }
    
}
