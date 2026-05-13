package bankapp.domain.services;

import org.springframework.stereotype.Service;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.AccountPort;
import bankapp.domain.models.Account;

@Service
public class FindAccount {
    private final AccountPort accountPort;

    public FindAccount(AccountPort accountPort) {
        this.accountPort = accountPort;
    }

    public Account findByAccountNumber(String accountNumber) throws BusinessException {
        Account account = accountPort.findAccountByAccountNumber(accountNumber);

        if (account == null) {
            throw new BusinessException("There is no account with that account number");
        }

        return account;
    }
}
