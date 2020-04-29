package pl.haladyj.wzjsontemplate.model;

import pl.haladyj.wzjsontemplate.payload.WzContent;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
public class Wz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sn;
    private Instant createdAt;
    private String description;

    @ElementCollection
    @CollectionTable(name = "wz_content")
    @MapKeyColumn(name = "wz_sn_product_id")
    protected Map<String, WzContent> products = new HashMap<String, WzContent>();

    public Wz() {
    }

    public Wz(Long id, String sn, Instant createdAt, String description, Map<String, WzContent> products) {
        this.id = id;
        this.sn = sn;
        this.createdAt = createdAt;
        this.description = description;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, WzContent> getProducts() {
        return products;
    }

    public void setProducts(Map<String, WzContent> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wz wz = (Wz) o;
        return Objects.equals(id, wz.id) &&
                Objects.equals(sn, wz.sn) &&
                Objects.equals(createdAt, wz.createdAt) &&
                Objects.equals(description, wz.description) &&
                Objects.equals(products, wz.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sn, createdAt, description, products);
    }
}
