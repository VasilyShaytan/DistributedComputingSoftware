package org.edu.kspt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "client", schema = "svdb", catalog = "")
public class Client {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "roleID")
    private int roleId;
    @Column(name = "money")
    private int money;
    @Column(name = "date")
    private Date date;

    public  Client() {}

    public Client(String login, String password, String name, String surname, int roleId, int money){
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.roleId = roleId;
        this.money = money;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
