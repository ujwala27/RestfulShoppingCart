package com.shop.appinfo.DB;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.shop.model.Cart;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@JsonAutoDetect
@Table(name = "ShoppingCart")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShoppingCartDB implements Serializable {

    @Id
    @JsonUnwrapped
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    private String productId;

    @Column(name = "product_desc", unique = true, nullable = false)
    private String productDesc;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private int quantity;
    
    @JsonUnwrapped
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Cart CartId;

    @JsonProperty
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty
    public String getProcuctDesc() {
        return productDesc;
    }

    public void setProcuctDesc(String applicationName) {
        this.productDesc = productDesc;
    }

    @JsonProperty
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
