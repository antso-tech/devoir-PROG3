package org.example;

import java.sql.*;

public class Users {
    String url = "jdbc:postgresql://localhost/users";
    String users = "postgres";
    String password = "ntsoa";

    String selectQuery = "SELECT * FROM USERS";
    public void getAllUsers(){
        try(Connection connection = DriverManager.getConnection(url,users,password)){
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);

            if(rs.next()){
                System.out.println("{name : " + rs.getString("name")
                        + ", firstname : " + rs.getString("firstname")
                + ", email : " + rs.getString("email") + ", password : "
                + rs.getString("password"));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);


        }
    }
    public static void main(String[] args) {

    }
}