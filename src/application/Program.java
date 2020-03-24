/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exception.DomainException;

/**
 *
 * @author enzoappi
 */
public class Program {
    
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        try { 
            System.out.print("Enter account data:\n");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial Balance: US$");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: US$");
            double withdrawLimit = sc.nextDouble();
            
            Account account = new Account(number, holder, balance, withdrawLimit);
            
            System.out.print("\n\nEnter amount for withdraw: ");
            double amount = sc.nextDouble();
            
            account.withdraw(amount);
            
            System.out.println("Amount balance: US$" + account.getBalance());
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        
    }
    
}
