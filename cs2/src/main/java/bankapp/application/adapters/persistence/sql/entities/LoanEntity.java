package bankapp.application.adapters.persistence.sql.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "loans")
@Getter
@Setter
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productCategory;

    @Column(nullable = false)
    private boolean approval;

    @Column(nullable = false)
    private String loanType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requesting_client_id", nullable = false)
    private ClientEntity requestingClient;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal requestedAmount;

    @Column(precision = 15, scale = 2)
    private BigDecimal approvedAmount;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal interestRate;

    @Column(nullable = false)
    private int termInMonths;

    @Column(nullable = false)
    private String loanState;

    @Temporal(TemporalType.DATE)
    @Column
    private Date approvalDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Date disbursementDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_account_product_id")
    private AccountEntity destinationAccount;
}