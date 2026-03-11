package bankapp.domain.models;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor

public abstract class Product {
    private String productID;
    private String ProductName;
    private ProdCategory productCategory;
    private boolean approval;
}
