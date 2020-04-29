package pl.haladyj.wzjsontemplate.service.dto;

import pl.haladyj.wzjsontemplate.payload.WzContent;

import java.time.Instant;
import java.util.Map;

public class WzDto {
    private String description;
    private String sn;
    private Instant createdAt;
    private Map<String,WzContent> products;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Map<String, WzContent> getProducts() {
        return products;
    }

    public void setProducts(Map<String, WzContent> products) {
        this.products = products;
    }
}
