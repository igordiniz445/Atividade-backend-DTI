/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dti_backend.Control;

import dti_backend.Models.Transaction;
import java.util.ArrayList;

/**
 *
 * @author igorc
 */
public class TransactionControl {
    private final ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    
    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }
    
    public ArrayList<Transaction> getTransactions(){
        return this.transactions;
    }
    
    /*
    *List all transactions in queue
    */
    public void listTransactions(){
        for(Transaction transaction : this.transactions){
            System.out.println(transaction.getOrigin().getName()+" transferiu R$ "
                    +transaction.getValue()+" para "
                    +UserControl.searchUser(transaction.getDestination()).getName()+"no dia "
                    +transaction.getDate());
        }
    }
    
    
    /*
    *Run all transactions in queue
    */
    public void runTransactions(){
        for(Transaction transaction : this.transactions){
            if(transaction.runTransaction()){
                System.out.println(transaction.getOrigin().getName()+" transferiu R$ "
                    +transaction.getValue()+" para "
                    +UserControl.searchUser(transaction.getDestination()).getName()+"no dia "
                    +transaction.getDate());
            }else{
                System.out.println(transaction.getOrigin().getName()+" nao pode transferir R$ "
                    +transaction.getValue()+" para "
                    +UserControl.searchUser(transaction.getDestination()).getName()+"no dia "
                    +transaction.getDate()+" por possuir saldo insuficiente (R$ "
                    +transaction.getOrigin().getBalance()+")");
            }
        }
    }
    
}
