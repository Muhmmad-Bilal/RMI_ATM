/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

//import com.bean.BalanceBean;
import com.bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Muhammad bilal
 */
public class UserDao {
 private Connection con;
 public UserDao(Connection con)
 {
     this.con=con;
 }
    
 public boolean saveUser(User user)
 {
  boolean f=false;
  try
  {
      String query="INSERT INTO account_details (user_name,user_password) VALUES (?,?) ";
     System.out.println(query);
      PreparedStatement pstm=this.con.prepareStatement(query);
      pstm.setString(1, user.getUserName());
      pstm.setInt(2, user.getPassword());
      pstm.executeUpdate();
      f=true;
  }catch(Exception e)
  {
      e.printStackTrace();
  }
  return f;
 }
 public User getUserByNamePassword(String name,int password)
 {
     User user=null;
     try
     {
         String query="Select * from account_details where user_name=? and user_password=? ";
         PreparedStatement pstm=con.prepareStatement(query);
         pstm.setString(1, name);
         pstm.setInt(2, password);
         ResultSet result=pstm.executeQuery();
         
         while(result.next())
         {
             user=new User();
             user.setId(result.getInt("ID"));
             user.setUserName(result.getString("user_name"));
             user.setPassword(result.getInt("user_password"));
             user.setBalance(result.getInt("total_amout"));
             
         }
         
     }catch(Exception e)
     {
         e.printStackTrace();
     }
     return user;
 }
 public User checkBalance(String name,int password)
 throws Exception{
User user=null;     
//BalanceBean balance=null;

     try
     {
  String query="Select * from account_details where user_name=? and user_password=?";
     
   System.out.println(query);
      PreparedStatement pstm=this.con.prepareStatement(query);
         pstm.setString(1, name);
         pstm.setInt(2, password);
         ResultSet result=pstm.executeQuery();
         
         while(result.next())
         {
             user=new User();
             user.setId(result.getInt("ID"));
             user.setUserName(result.getString("user_name"));
             user.setPassword(result.getInt("user_password"));
             user.setBalance(result.getInt("total_amout"));
         }
 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    return user;
 }
 public void deposit(String name,int password,int money)
 throws Exception{
     String query="update account_details set total_amout = total_amout + ? where user_name=? and user_password=?";
     System.out.println(query);
     
     try
     {
         PreparedStatement pstm=this.con.prepareStatement(query);
         pstm.setInt(1, money);
         pstm.setString(2, name);
         pstm.setInt(3,password);
         int result=pstm.executeUpdate();
         if(result>0)
         {
             System.out.println("Successfuly deposit");
         }
        
               
     }finally
     {
         
     }
     
 }
 public void withdraw(String name,int password,int money)
 throws Exception{
     String query="update account_details set total_amout = total_amout - ? where user_name=? and user_password=?";
     System.out.println(query);
     
     try
     {
         PreparedStatement pstm=this.con.prepareStatement(query);
         pstm.setInt(1, money);
         pstm.setString(2, name);
         pstm.setInt(3,password);
         int result=pstm.executeUpdate();
         if(result>0)
         {
             System.out.println("Successfuly withdraw");
         }
        
               
     }finally
     {
         
     }
     
 }
}
