package controller;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLManager {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private static MySQLManager instance;

    public static MySQLManager getInstance() {
        if(instance == null) {
            instance = new MySQLManager();
        }
        return instance;
    }
    private MySQLManager() {
        String url = "jdbc:mysql://localhost:3306/apprendrejava";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root","root");
        } catch (SQLException e){
            System.out.println("prblm de la connexion à la bdd");
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
