package dao;

import controller.MySQLManager;
import model.DataEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DataDAO {

    public DataEntity findById(int id){
        // requete a la bdd
        String query = "SELECT * FROM user WHERE id = ?";
        try{
            Connection connection = MySQLManager.getInstance().getConnection();
            PreparedStatement stat = connection.prepareStatement(query);
            stat.setInt(1, id);
            ResultSet res = stat.executeQuery();
            res.next();
            DataEntity dataEntity = new DataEntity(
                    id,
                    res.getString("login"),
                    res.getString("pwd"),
                    res.getString("prenom")
            );
            return dataEntity;
        }catch (SQLException e){
            System.out.println("erreur sql pour" + query);
            System.out.println(e.getMessage());
        }
        return null;
    }
}
