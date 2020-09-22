/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dti_backend.Control;

import dti_backend.Models.User;
import java.util.ArrayList;

/**
 *
 * @author igorc
 */
public class UserControl {
    private static ArrayList<User> users;

    public UserControl() {
        this.users = new ArrayList<User>();
    }

    public ArrayList<User> getUsuarios() {
        return users;
    }
    
    public void addUser(User user){
        for(User savedUser : this.users){
            if(savedUser.getCod().compareToIgnoreCase(user.getCod()) == 0){
                /*Se já existe um usuário com esse mesmo ID, não pode adicional*/
                System.out.println("Já existe um usuário com este mesmo ID = ["+savedUser.getCod()+"]");
                return;
            }
        }
        this.users.add(user);
    }
    
    public static User searchUser(String id){
        for(User user : users){
            if(user.getCod().compareToIgnoreCase(id) == 0){
                return user;
            }
        }
        return null;
    }
    
    public void listBalance(){
        System.out.println("Saldos:");
        for(User user : this.users){
            System.out.println(user.getName()+" - R$ "+user.getBalance());
        }
    }
}
