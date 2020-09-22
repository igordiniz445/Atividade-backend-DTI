package dti_backend.Models;

import dti_backend.Control.UserControl;

/**
 * @author Igor O. C. Diniz
 */
public class Transaction {
    private User origin;
    private double value;
    private String date;
    //date was suppost to be Date type, but was getting issues to convert it, with more time I would change it to Date type
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
    
    /*
    * Method to run a single transaction
    */
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
