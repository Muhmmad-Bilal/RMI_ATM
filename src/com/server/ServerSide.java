/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server;
import com.interfaceImplement.LoginImplement;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Muhammad bilal
 */
public class ServerSide  {
    public static void main(String arg[])
    {
        try
        {
        Registry reg=LocateRegistry.createRegistry(1099);
        
        LoginImplement lo=new LoginImplement();
       
        Naming.rebind("login",lo);
        
        System.out.println("Server is ready");
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
       
}
