/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiatm;

import com.bean.User;
import com.database.ConnetionProvider;
import com.entities.UserDao;
import com.interfacemethod.RemoteAtmMethods;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad bilal
 */
public class ClientSide {
 RemoteAtmMethods atm;
    ClientSide() throws Exception
{
     Registry reg=LocateRegistry.getRegistry("127.0.0.1",1099);
    atm=(RemoteAtmMethods)reg.lookup("login");
   
    menuatm();
}
    
    Scanner scan=new Scanner(System.in);
    public void menuatm()
    throws Exception{
        do{
         System.out.println("********Hi! Welcome to BSIT/SW Part IV ATM Machine!*******\n\n\n");
         System.out.println("Please select an option from the menu below:");
        System.out.println("l. Login");
        System.out.println("c. Create Account");
        System.out.println("q. Quit");
        
        char option=scan.next().charAt(0);
        if(option=='l' || option=='L')
        {
            logIn();    
        }
        if(option=='c' || option=='C')
        {
            signOut();
        }
        if(option=='q' || option=='Q' )
        {
            quit();
        }
        }while(true);
        
    }
    public void logIn()
    {
        try
        {
        System.out.print("Enter Your  User id: ");
        String name=scan.next();
        System.out.print("Enter Your Password: ");
        int pass=scan.nextInt();
       boolean found= atm.getLogin(name, pass);
        if(found==true)
            {
                
               System.out.println("\tAccess granted");
       
               do{
               System.out.println("********Welcome to Your Account********");
        Scanner scan=new Scanner(System.in);
        System.out.println("d-> Deposit Money");
        System.out.println("W-> Withdraw Money");
        System.out.println("r-> Request Balance");
        System.out.println("q-> Quit");
        char select=scan.next().charAt(0);
        
        switch(select)
        {
            case 'd':
               
               deposit( name, pass);
                break;
            case 'w':
                withdraw(name,pass);
                break;
            case 'r':
                balance(name,pass);
                break;
            case 'q':
                System.out.println("Thanks for Stoping  By!");
                quit();
                break;
            default:
                System.out.println("Enter Valid Choice");   
                
            }
               }while(true);
            }
        else
        {
         System.out.println("   ******** LOGIN FAILED! Please try again. Good by ********");
         System.exit(0);
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void signOut()
    {
 
        try
        {
     System.out.print("Please Enter Your User Name:");
     String userName=scan.next();
     System.out.print("\nPlease Enter Your Password: ");
     int password=scan.nextInt();
     boolean found=atm.getSignOut(userName, password);
        if(found)
        {
            System.out.println("Thank You! Your account has been created!");
        }
        else
        {
            System.out.println("Error");
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            }
    public void deposit(String name,int password)
    {
        try
        {
        System.out.println("Enter Amount to deposit");
        int amount=scan.nextInt();
        atm.deposit(name, password, amount);
        System.out.println("Amount  has been desposit $"+amount);
        }catch(Exception  e)
        {
            e.printStackTrace();
        }
    }
    public void withdraw(String name,int password)
    {
        System.out.println("Enter Amount to Withdraw ");
        int amount=scan.nextInt();
     try {
         atm.withdraw(name,password , amount);
         System.out.println("Amount Withdraw  $"+amount);
     } catch (RemoteException ex) {
         Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    public void balance(String name,int password) 
    {
        try
        {
        int balance=atm.checkBalance(name, password);
        System.out.println(name+""+password);
        System.out.println("Your balance is:"+balance);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void quit()
    {
        System.exit(0);
    }
public static void main(String arg[])
{
    try {
       
        ClientSide client=new ClientSide();
    } catch (Exception ex) {
        Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
