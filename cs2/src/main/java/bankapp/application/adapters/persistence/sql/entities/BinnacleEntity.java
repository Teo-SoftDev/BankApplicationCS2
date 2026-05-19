package bankapp.application.adapters.persistence.sql.entities;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "binnacles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BinnacleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long binnacleId;

    @Column(nullable = false)
    private String operationType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date operationDate;

    @Column(nullable = false)
    private Long userId;

    @Column
    private Long productId;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String detailsJson;
}