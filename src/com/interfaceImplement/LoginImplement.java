/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfaceImplement;

//import com.bean.BalanceBean;
import com.bean.User;
import com.database.ConnetionProvider;
import com.entities.UserDao;
import com.interfacemethod.RemoteAtmMethods;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
/**
 *
 * @author Muhammad bilal
 */
public class LoginImplement extends UnicastRemoteObject implements RemoteAtmMethods {
    
   public LoginImplement()
    throws Exception{
        
    }
 
   @Override
    public boolean getLogin(String name,int password)
    {
        
        boolean f=false;
        System.out.println(name);
        System.out.println(password);
       UserDao dao=new UserDao(ConnetionProvider.getConnection());
        User user=dao.getUserByNamePassword(name, password);
     System.out.println(user.getUserName());
     System.out.println(user.getPassword());
        if(user.getUserName().equals(name) && user.getPassword()==password)
     {
         
         f=true;
    }
         return f;
    }
       
    
    
    public boolean  getSignOut(String name,int password)
    {
        System.out.println(name+""+password);
        boolean f=false;
        try
        {
         UserDao dao=new UserDao(ConnetionProvider.getConnection());
            User user=new User(name,password);
    
        if(dao.saveUser(user))
        {
           // System.out.println("Thank You! Your account has been created!");
           f=true;
        }
        else
        {
            System.out.println("Not Registered");
        }
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
        
    }
    public int checkBalance(String name,int password)
    {
        int row=0;
     try
     {
         System.out.println(name+"check  "+password);
      
      UserDao dao=new UserDao(ConnetionProvider.getConnection());
      User user=dao.checkBalance(name, password);
System.out.println(user.getBalance());      
row=user.getBalance();
//String n=user.getUserName();
//System.out.println(n);
          
     }catch(Exception e)
     {
         e.printStackTrace();
     }
    return row;
    }
    public void deposit(String name,int password,int money)
    {
      try
      {
          UserDao dao=new UserDao(ConnetionProvider.getConnection());
          dao.deposit(name, password, money);
      }catch(Exception e)
      {
          e.printStackTrace();
      }
   }
    public void withdraw(String name,int password,int money)
   {
        try
        {
          UserDao dao=new UserDao(ConnetionProvider.getConnection());
          dao.withdraw(name, password, money);  
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
     
 }
}
