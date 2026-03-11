package bankapp.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor

public class Binnacle {
    private long binnacleId;
    private String operationType;
    private Date operationDate;
    private User userId;
    private Product productId;
    private String details;
}
