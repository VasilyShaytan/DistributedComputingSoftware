package org.edu.kspt.entity;


import javax.persistence.*;

@Entity
@Table(name = "userorder", schema = "svdb", catalog = "")
public class UserOrder {
    @Id
    @GeneratedValue
    @Column(name = "userorder_id")
    private int userOrderId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "amount")
    private int amount;
    @Column(name = "statusmorder")
    private byte statusMOrder;
    @Column(name = "statusppayorder")
    private byte statusPPayOrder;
    @Column(name = "statusfullorder")
    private byte statusFullPayOrder;

    public UserOrder() {}

    public UserOrder(/*int uoid,*/ int uid, int am, byte smo, byte sppo, byte sfpo){
        //this.userOrderId = uoid;
        this.userId = uid;
        this.amount = am;
        this.statusMOrder = smo;
        this.statusPPayOrder = sppo;
        this.statusFullPayOrder = sfpo;
    }

    public int getUserOrderId() {
        return userOrderId;
    }

    public void setUserOrderId(int userOrderId) {
        this.userOrderId = userOrderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public byte getStatusMOrder() {
        return statusMOrder;
    }

    public void setStatusMOrder(byte statusMOrder) {
        this.statusMOrder = statusMOrder;
    }

    public byte getStatusPPayOrder() {
        return statusPPayOrder;
    }

    public void setStatusPPayOrder(byte statusPPayOrder) {
        this.statusPPayOrder = statusPPayOrder;
    }

    public byte getStatusFullPayOrder() {
        return statusFullPayOrder;
    }

    public void setStatusFullPayOrder(byte statusFullPayOrder) {
        this.statusFullPayOrder = statusFullPayOrder;
    }
}
