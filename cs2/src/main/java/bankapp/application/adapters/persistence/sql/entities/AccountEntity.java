package bankapp.application.adapters.persistence.sql.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import bankapp.domain.models.AccountType;
import bankapp.domain.models.Currency;
import bankapp.domain.models.AccountState;
import bankapp.domain.models.ProdCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Id
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProdCategory productCategory;

    @Column(nullable = false)
    private boolean approval;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "holder_id", nullable = false)
    private ClientEntity holder;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal currentBalance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currencyType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountState accountState;

    @Column(nullable = false)
    private LocalDate openingDate;
}