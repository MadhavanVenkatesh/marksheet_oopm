package com.example.demo;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {
    public Connection dbconnect;
    public Connection getDbconnect(){
        String dbname="marks";
        String url="jdbc:mysql://localhost:3306/marks";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbconnect=DriverManager.getConnection(url,"root","maddyvenky@2002");
        }catch (Exception e){
            e.printStackTrace();
        }
        return dbconnect;
    }


}
