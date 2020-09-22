package dti_backend.Control;

import dti_backend.Models.Transaction;
import java.util.ArrayList;

/**
 * @author Igor O. C. Diniz
 * 
 * A control class to store all Transactions.
 * The class is abstract and all methods are static, so you don't need to instance this class to have access to Transactions
 */
public abstract class TransactionControl {
    private static final ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    
    public static void addTransaction(Transaction t){
        transactions.add(t);
    }
    
    public static ArrayList<Transaction> getTransactions(){
        return transactions;
    }
    
    /*
    *List all transactions in queue
    */
    public static void listTransactions(){
        for(Transaction transaction : transactions){
            System.out.println(transaction.getOrigin().getName()+" transferiu R$ "
                    +transaction.getValue()+" para "
                    +UserControl.searchUser(transaction.getDestination()).getName()+"no dia "
                    +transaction.getDate());
        }
    }
    
    /*
    *Run all transactions in queue
    */
    public static void runTransactions(){
        for(Transaction transaction : transactions){
            if(transaction.runTransaction()){
                //If was possible to run the transaction, the print the success
                System.out.println(transaction.getOrigin().getName()+" transferiu R$ "
                    +transaction.getValue()+" para "
                    +UserControl.searchUser(transaction.getDestination()).getName()+"no dia "
                    +transaction.getDate());
            }else{
                //If transaction fails, then print that wan't possible to run transaction
                System.out.println(transaction.getOrigin().getName()+" nao pode transferir R$ "
                    +transaction.getValue()+" para "
                    +UserControl.searchUser(transaction.getDestination()).getName()+"no dia "
                    +transaction.getDate()+" por possuir saldo insuficiente (R$ "
                    +transaction.getOrigin().getBalance()+")");
            }
        }
    }
    
}
