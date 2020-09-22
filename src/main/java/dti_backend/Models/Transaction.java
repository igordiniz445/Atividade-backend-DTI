/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dti_backend.Models;

import dti_backend.Control.UserControl;

/**
 *
 * @author igorc
 */
public class Transaction {
    private User origin;
    private double value;
    private String date;
    private String destinationId;

    public Transaction(User origin, double value, String date, String destination) {
        this.origin = origin;
        this.value = value;
        this.destinationId = destination;
        this.date = date;
    }

    public User getOrigin() {
        return origin;
    }

    public double getValue() {
        return value;
    }

    public String getDestination() {
        return destinationId;
    }

    public String getDate() {
        return this.date;
    }
    
    public boolean runTransaction(){
        User destination = UserControl.searchUser(this.destinationId);
        if(this.origin.withdraw(this.value)){
            destination.deposit(value);
            return true;
        }else{
            return false;
        }
    }
    
}
