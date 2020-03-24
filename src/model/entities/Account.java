/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import model.exception.DomainException;

/**
 *
 * @author enzoappi
 */
public class Account {
    
    protected Integer number;
    protected String holder;
    protected Double balance;
    protected Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
    
    public void deposit(Double amount) {
        this.balance += amount;
    }
    
    public void withdraw(Double amount) throws DomainException{
        if(amount > this.balance) {
            throw new DomainException("The amount must be lesser "
                    + "than the balance");
        }
        if(amount > this.withdrawLimit) {
            throw new DomainException("The amount must be lesser "
                    + "than the withdraw amount permited");
        }
        this.balance -= amount;
    }
    
    
    
}
