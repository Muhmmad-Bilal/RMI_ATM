/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfacemethod;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Muhammad bilal
 */
public interface RemoteAtmMethods extends Remote {
    public boolean getLogin(String name,int password)throws RemoteException;
        public boolean getSignOut(String name,int password)throws RemoteException; 
        public int  checkBalance(String name,int password)throws RemoteException;
        public void deposit(String name,int password,int money)throws RemoteException;
        public void withdraw(String name,int password,int money)throws  RemoteException;
         //public boolean deposit()throws RemoteException;
        //public boolean withdraw()throws RemoteException;
        
}
