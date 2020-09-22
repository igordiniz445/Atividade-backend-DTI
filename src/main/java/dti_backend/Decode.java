package dti_backend;

import dti_backend.Models.Transaction;
import dti_backend.Models.User;
import dti_backend.Control.UserControl;
import dti_backend.Control.TransactionControl;

/**
 *
 * @author igorc
 */
public class Decode {
    
    public static void decodeLine(String line, TransactionControl tc, UserControl uc){
        
        
        int marcador = indexDoDivisor(line)+1;
        /*Procura o primeiro divisor "-%p" e retorna o indice dele*/
        String id = line.substring(0, marcador);
        line = line.substring(marcador+3);
        
        marcador = indexDoDivisor(line)+1;
        
        Double saldo = Double.parseDouble(line.substring(0, marcador));
        line = line.substring(marcador+3);
        
        marcador = indexDoDivisor(line)+1;
        String nome = line.substring(0, marcador);
        line = line.substring(marcador+3);
        
        marcador = indexDoDivisor(line)+1;
        String date = formatDate(line.substring(0, marcador));
        
        line = line.substring(marcador+3);
        
        marcador = indexDoDivisor(line)+1;
        Double valor = Double.parseDouble(line.substring(0, marcador));
        line = line.substring(marcador+3);
        
        String destinoID = line;
        
        
        User user = new User(id,saldo,nome);
        Transaction transaction = new Transaction(user, valor, date, destinoID);
        
        uc.addUser(user);
        tc.addTransaction(transaction);
        
    }
    
    private static int indexDoDivisor(String line){
        return line.indexOf("-%p")-1;
    }
    
    private static String formatDate(String oldDate){
        String year = oldDate.substring(0, 4);
        String month = oldDate.substring(5, 7);
        String day = oldDate.substring(8, 10);
        return day+"/"+month+"/"+year;
    }
    
}
