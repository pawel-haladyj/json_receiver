package pl.haladyj.wzjsontemplate.payload;

import javax.persistence.Embeddable;

@Embeddable
public class WzContent {

    private String productCode;
    private Long productQuantity;

    public WzContent() {
    }

    public WzContent(String productCode, Long productQuantity) {
        this.productCode = productCode;
        this.productQuantity = productQuantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

}
