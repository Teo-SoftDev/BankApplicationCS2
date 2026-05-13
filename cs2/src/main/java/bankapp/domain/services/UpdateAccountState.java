package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.models.Account;
import bankapp.domain.ports.AccountPort;
import bankapp.domain.models.AccountState;

@Service
public class UpdateAccountState {

    private final AccountPort accountPort;

    public UpdateAccountState(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    public void updateAccountState(String accountNumber, AccountState accountState) throws BusinessException {

        Account account = accountPort.findAccountByAccountNumber(accountNumber);

        if(account == null) {
            throw new BusinessException("There is no an account with that account number");
        }

        account.setAccountState(accountState);
        accountPort.updateAccountState(account);
    }
    
}
