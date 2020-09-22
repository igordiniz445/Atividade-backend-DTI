/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dti_backend.Models;


public class User {
    private String cod;
    private double balance;
    private String name;

    public User(String cod, double balance, String name) {
        this.cod = cod;
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getCod() {
        return cod;
    }
    
    public void deposit(double value){
        if(value>0){
            this.balance += value;
        }else{
            System.out.println("Valor de depósito não pode ser negativo");
        }
    }
    
    public boolean withdraw(double value){
        if(this.balance > value){
            this.balance -= value;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuario: [" + "UUID = " + cod + ", Nome = " + name+ ", Saldo = R$" + balance +" ]" ;
    }
    
    
    
}
