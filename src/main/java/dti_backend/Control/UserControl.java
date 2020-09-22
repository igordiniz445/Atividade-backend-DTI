package dti_backend.Control;

import dti_backend.Models.User;
import java.util.ArrayList;

/**
 * @author Igor O. C. Diniz
 * 
 * A control class to store all the Users.
 * The class is abstract and all methods are static, so you don't need to instance this class to have access to the Users
 */
public abstract class UserControl {
    private static final ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> getUsers() {
        return users;
    }
    
    public static void addUser(User user){
        for(User savedUser : users){
            if(savedUser.getCod().compareToIgnoreCase(user.getCod()) == 0){
                /*Se já existe um usuário com esse mesmo ID, não pode adicional*/
                System.out.println("Já existe um usuário com este mesmo ID = ["+savedUser.getCod()+"]");
                return;
            }
        }
        users.add(user);
    }
    
    public static User searchUser(String id){
        for(User user : users){
            if(user.getCod().compareToIgnoreCase(id) == 0){
                return user;
            }
        }
        return null;
    }
    
    public static void listBalance(){
        System.out.println("Saldos:");
        for(User user : users){
            System.out.println(user.getName()+" - R$ "+user.getBalance());
        }
    }
}
