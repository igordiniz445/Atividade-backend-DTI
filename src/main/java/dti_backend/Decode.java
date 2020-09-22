package dti_backend;

import dti_backend.Models.Transaction;
import dti_backend.Models.User;
import dti_backend.Control.UserControl;
import dti_backend.Control.TransactionControl;

/**
 * @author Igor O. C. Diniz
 */
public class Decode {
    
    public static void decodeLine(String line){

        int marcador = indexDoDivisor(line)+1;
        //Look for the first "-%p" and return it's index//
        String id = line.substring(0, marcador);
        //Saves the substring with the UUID on id
        line = line.substring(marcador+3);
        //Line receive the rest of the file line, without the UUID
        
        marcador = indexDoDivisor(line)+1;
        //Look for the first "-%p" and return it's index//
        Double balance = Double.parseDouble(line.substring(0, marcador));
        //Gets the substring with the balance, and convert it to Double
        line = line.substring(marcador+3);
        //Line receive the rest of the file line, without the Balance
        
        marcador = indexDoDivisor(line)+1;
        //Look for the first "-%p" and return it's index//
        String name = line.substring(0, marcador);
        //Gets the substring with the name, and saves it
        line = line.substring(marcador+3);
        //Line receive the rest of the file line, without the Name
        
        marcador = indexDoDivisor(line)+1;
        //Look for the first "-%p" and return it's index//
        String date = formatDate(line.substring(0, marcador));
        //Gets the substring with the date
        line = line.substring(marcador+3);
        //Line receive the rest of the file line, without the Transferation Date
        
        marcador = indexDoDivisor(line)+1;
        //Look for the first "-%p" and return it's index//
        Double valor = Double.parseDouble(line.substring(0, marcador));
        //Gets the substring with the transferation value, and convert it to Double
        line = line.substring(marcador+3);
        //Line receive the rest of the file line, which is the user ID to receive the transaction
        
        String destineUserID = line;
        //saves the user ID that will receive the transaction
        
        
        User user = new User(id,balance,name);
        //Build a User object
        Transaction transaction = new Transaction(user, valor, date, destineUserID);
        //Build a Transaction object
        
        UserControl.addUser(user);
        //Add user on the UserControl list
        TransactionControl.addTransaction(transaction);
        //Add transaction on TransactionControl list
    }
    
    /*
    * Funcion to return the index of the divisor
    * @param line with the File's current line
    */
    private static int indexDoDivisor(String line){
        return line.indexOf("-%p")-1;
    }
    /*
    *Function to format the Date of the file, to PT-BR format
    */
    private static String formatDate(String oldDate){
        String year = oldDate.substring(0, 4);
        String month = oldDate.substring(5, 7);
        String day = oldDate.substring(8, 10);
        return day+"/"+month+"/"+year;
    }
    
}
