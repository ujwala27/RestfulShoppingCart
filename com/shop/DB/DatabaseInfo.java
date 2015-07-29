package com.shop.DB;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@JsonAutoDetect
@Table(name = "database_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DatabaseInfo implements Serializable {

    @Id
    @JsonUnwrapped
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ProductId", unique = true, nullable = false)
    private int ProductId;

    @Column(name = "ProductDesc", unique = true, nullable = false)
    private String ProductDesc;

    @Column(name = "price", unique = true, nullable = true)
    private String price;
    
    @Column(name = "quantity", unique = true, nullable = true)
    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @JsonProperty
    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    @JsonProperty
    public String getProductDesc() {
        return ProductDesc;
    }

    public void setProductDesc(String ProductDesc) {
        this.ProductDesc = ProductDesc;
    }

    @JsonProperty
    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }
    
    @JsonProperty
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

     @JsonProperty
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
