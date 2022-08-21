/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

/**
 *
 * @author Muhammad bilal
 */
public class User {
    private int id;
    private String userName;
    private int password;
    private int balance;
    
    public User() {
    }

   

    public User(String userName, int password,int balance) {
        this.userName = userName;
        this.password = password;
       this.balance=balance;
    }

    public User(String userName, int password) {
        this.userName = userName;
        this.password = password;
    }
    
    

    
    
    public User(int id, String userName, int password,int balance) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.balance=balance;
       
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
}
