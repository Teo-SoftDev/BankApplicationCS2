package bankapp.domain.models;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor

public abstract class Product {
    private Long productId;
    private String productName;
    private ProdCategory productCategory;
    private boolean approval;
}
