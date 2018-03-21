package org.edu.kspt.entity;

import javax.persistence.*;

@Entity
@Table(name = "productinstock", schema = "svdb", catalog = "")
public class ProductInStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_count")
    private int productCount;
    @Column(name = "product_price")
    private int productPrice;

    public ProductInStock() {}

    public ProductInStock(int pid, String pn, int pc, int pp) {
        this.productId = pid;
        this.productName = pn;
        this.productCount = pc;
        this.productPrice = pp;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
