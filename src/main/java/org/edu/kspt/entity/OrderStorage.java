package org.edu.kspt.entity;

import javax.persistence.*;


@Entity
@Table(name = "orderstorage", schema = "svdb", catalog = "")
public class OrderStorage {
    @Id
    @GeneratedValue()
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "userorder_id")
    private int userOrderId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_count")
    private int productCount;

    public OrderStorage(int oid, int coid, int pid, int pc) {
        this.orderId = oid;
        this.userOrderId = coid;
        this.productId = pid;
        this.productCount = pc;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserOrderId() {
        return userOrderId;
    }

    public void setUserOrderId(int userOrderId) {
        this.userOrderId = userOrderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
