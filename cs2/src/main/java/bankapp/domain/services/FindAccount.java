package bankapp.domain.services;

import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.AccountPort;
import bankapp.domain.models.Account;

public class FindAccount {
    private AccountPort accountPort;

    public Account findByAccountNumber(String accountNumber) throws BusinessException {
        Account account = accountPort.findAccountByAccountNumber(accountNumber);

        if (account == null) {
            throw new BusinessException("There is no account with that account number");
        }

        return account;
    }
}
