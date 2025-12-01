package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Users {
    String url = "jdbc:postgresql://localhost/users";
    String users = "postgres";
    String password = "ntsoa";



    public void getAllUsers(){
        try(Connection connection = DriverManager.getConnection(url,users,password)){
            Statement st = connection.createStatement()
        }catch (SQLException e){


        }
    }
    public static void main(String[] args) {

    }
}