package bankapp.application.adapters.persistence.sql.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transfers")
@Getter
@Setter
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransfer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "origin_account_product_id", nullable = false)
    private AccountEntity originAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_account_product_id", nullable = false)
    private AccountEntity destinationAccount;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column
    private LocalDate approvalDate;

    @Column(nullable = false)
    private String transferState;
}
