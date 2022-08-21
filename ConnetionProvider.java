/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Muhammad bilal
 */
public class ConnetionProvider {
     private static Connection con;
    public static Connection getConnection()
    {
        try
        {
          if(con==null)
          {
              //Driver Class Load
               Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            //Connection
               con=DriverManager.getConnection("jdbc:ucanaccess://E:\\java_prog\\Databases\\RMIAtm.accdb");
            
          }      
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return con;
    }
}
