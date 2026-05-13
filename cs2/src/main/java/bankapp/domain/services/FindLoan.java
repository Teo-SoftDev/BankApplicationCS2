package bankapp.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import bankapp.domain.models.Client;
import bankapp.domain.Exceptions.BusinessException;
import bankapp.domain.ports.ClientPort;
import bankapp.domain.ports.LoanPort;
import bankapp.domain.models.Loan;
import bankapp.domain.models.User;

@Service
public class FindLoan {
    private final LoanPort loanPort;
    private final ClientPort clientPort;

    public FindLoan(LoanPort loanPort, ClientPort clientPort) {
        this.loanPort = loanPort;
        this.clientPort = clientPort;
    }

    public Loan findById(long loanId) throws BusinessException {
        Loan loan = loanPort.findById(loanId);

        if (loan == null) {
            throw new BusinessException("There is no loan with that id");
        }

        return loan;
    }

    public List<Loan> findLoanByClient(String document, User user) throws BusinessException {
        Client client = clientPort.findByDocument(document);

        if(client == null) {
            throw new BusinessException("There's no client with the document" + document);
        }

        return loanPort.findLoanByClient(client);
    }
}