package bankapp.application.adapters.persistence.sql.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private boolean approval;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "holder_id", nullable = false)
    private ClientEntity holder;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal currentBalance;

    @Column(nullable = false)
    private String currencyType;

    @Column(nullable = false)
    private String accountState;

    @Column(nullable = false)
    private LocalDate openingDate;
}