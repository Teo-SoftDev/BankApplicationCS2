package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.AccountPort;
import bankapp.domain.models.Account;

@Service
public class CreateAccount {

    private final AccountPort accountPort;

    public CreateAccount(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    public void createAccount(Account account) throws BusinessException {

        if (accountPort.existsByAccountNumber(account.getAccountNumber())) {
            throw new BusinessException("There is already an account with that account number.");
        }

        accountPort.saveAccount(account);
        
    }
}
