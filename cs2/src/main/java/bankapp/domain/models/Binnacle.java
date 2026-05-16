package bankapp.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;


@Setter
@Getter
@NoArgsConstructor

public class Binnacle {
    private Long binnacleId;
    private OperationType operationType;
    private Date operationDate;
    private User userId;
    private Product productId;
    private Map<String, Object> details;
}
