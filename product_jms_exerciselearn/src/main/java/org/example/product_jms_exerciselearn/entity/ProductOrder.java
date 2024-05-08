package org.example.product_jms_exerciselearn.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@Entity
@ToString

@Table(name="product_order")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false, unique = true)
    private int id;
    @Column(columnDefinition = "NVARCHAR(40)",name = "customerName", nullable = false)
    private String customerName;
    @Column(columnDefinition = "NVARCHAR(11)", name = "customerAddress", nullable = false)
    private String customerAddress;
    @Column(columnDefinition = "NVARCHAR(11)", name = "customerPhone", nullable = false)
    private String phone;

    public ProductOrder() {
    }

    public ProductOrder(String customerName, String customerAddress, String phone) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductOrder that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
