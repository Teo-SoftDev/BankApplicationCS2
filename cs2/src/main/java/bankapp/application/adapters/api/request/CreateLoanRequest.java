package bankapp.application.adapters.api.request;

import java.math.BigDecimal;

import bankapp.domain.models.LoanState;
import bankapp.domain.models.LoanType;
import bankapp.domain.models.ProdCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLoanRequest {
    private LoanType loanType;
    private String productName;
    private String clientDocument;
    private BigDecimal requestedAmount;
    private BigDecimal interestRate;
    private String destinationAccountNumber;
    private int termInMonths;

    public static bankapp.domain.models.Loan toEntity(CreateLoanRequest request) {
        bankapp.domain.models.Loan loan = new bankapp.domain.models.Loan();
        loan.setLoanType(request.getLoanType());
        loan.setProductName(request.getProductName());
        loan.setRequestedAmount(request.getRequestedAmount());
        loan.setInterestRate(request.getInterestRate());
        loan.setTermInMonths(request.getTermInMonths());
        loan.setProductCategory(ProdCategory.LOAN);
        loan.setLoanState(LoanState.INSTUDY);
        return loan;
    }
}
