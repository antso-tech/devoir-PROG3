package org.example;

import java.sql.*;
import java.time.LocalDate;

public class Users {
    String url = "jdbc:postgresql://localhost/users";
    String users = "postgres";
    String password = "ntsoa";

    String selectQuery = "SELECT * FROM USERS";
    String createQuery = "INSERT INTO" +
            " USERS (name, firstname, birthdate, email, password) " +
            "VALUES (?, ?, ?, ?,?) ON " +
            "CONFLICT (name, firstname, birthdate, email, password)" +
            " DO NOTHING RETURNING id_users";

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

    public void createNewUser(String name, String firstname, LocalDate birthdate, String email, String password){
        try(Connection connection = DriverManager.getConnection(url,users,this.password)){
            PreparedStatement ps = connection.prepareStatement(createQuery);

            ps.setString(1, name);
            ps.setString(2, firstname);
            ps.setDate(3, Date.valueOf(birthdate));
            ps.setString(4,email);
            ps.setString(5, password);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    int newId = rs.getInt(1);
                    System.out.println("New Task created !");
                }
            }

        }catch(SQLException e){
            if(e.getMessage().contains("dupliquée")){
                System.out.println("This task is already exists");
            }
            throw new RuntimeException(e);

        }
    }
    public static void main(String[] args) {
        Users user = new Users();
        user.getAllUsers();
    }
}