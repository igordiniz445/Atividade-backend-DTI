package dti_backend;


import dti_backend.Control.UserControl;
import dti_backend.Control.TransactionControl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igorc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String currentDir = new File("").getAbsoluteFile().toString()+"\\dados.txt";
        System.out.println(currentDir);
        File file = new File(currentDir); 
        TransactionControl transactionControl = new TransactionControl();
        UserControl userControl = new UserControl();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while(line!= null){
                Decode.decodeLine(line,transactionControl, userControl);
                line = br.readLine();
            }
            
            System.out.println("");
            userControl.listBalance();

            System.out.println("");
            transactionControl.runTransactions();
            
            System.out.println("");
            userControl.listBalance();
            
        }catch(FileNotFoundException e){
            System.out.println("Não foi possível encontrar o arquivo.");
        }catch(IOException ex) {
            System.out.println("Não foi possível ler o arquivo");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
