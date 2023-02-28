package org.example;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

import java.sql.Connection;
 class Database {
    static Database data=null;
    Logger s = Logger.getLogger("com.api.jar");

    Connection conn;
    private Database() {

    }
    public static  Database getdatabase() {
        if (data == null)
            data = new Database();
        return data;
    }
    void open(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        s.info("Connection established");

    }

     void close1()  throws SQLException{

        conn.close();
        s.info("Connection closed");
    }

     public static void main(String[] args) throws SQLException {
         Logger s=Logger.getLogger("com.api.jar");
         Scanner sc = new Scanner(System.in);


           s.info("1.New Connection opened /n 2,Close the connection");
           s.info("Enter your choice:");
           int option=sc.nextInt();
         Database d = Database.getdatabase();
           if(option==1) {

               s.info("Enter the database URL:");
               String url = sc.next();
               s.info("Enter the username:");
               String username = sc.next();
               s.info("Enter the password:");
               String password = sc.next();
               d.open(url, username, password);
               d.close1();
           }
               else{
                   s.info("Invalid choice");
           }

     }
 }

