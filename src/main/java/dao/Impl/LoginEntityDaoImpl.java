package dao.Impl;

import common.DbConnection;
import dao.LoginEntityDao;
import entity.LoginEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginEntityDaoImpl implements LoginEntityDao {
    public LoginEntity insert(LoginEntity entity) {
        String sql = "INSERT INTO `tbl_user`(`unique_id`, `nama`, `email`, `encrypted_password`, `salt`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, entity.getUnique_id());
            statement.setString(2, entity.getNama());
            statement.setString(3, entity.getEmail());
            statement.setString(4,entity.getEncrypted_password());
            statement.setString(5,entity.getSalt());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return entity;
    }

    public LoginEntity update(LoginEntity entity) {
        return null;
    }

    public Boolean delete(LoginEntity entity) {
        return null;
    }

    public LoginEntity findById(int id) {
        LoginEntity le = new LoginEntity();
        String sql = "SELECT * from `tbl_user` WHERE id = ?";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                le.setId(result.getInt("id"));
                le.setUnique_id(result.getString("unique_id"));
                le.setNama(result.getString("nama"));
                le.setEmail(result.getString("email"));
                le.setEncrypted_password(result.getString("encrypted_password"));
                le.setSalt(result.getString("salt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return le;
    }

    public List<LoginEntity> find() {
        List<LoginEntity> loginEntities = new ArrayList<>();
        String sql = "SELECT * from `tbl_user`";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                LoginEntity le = new LoginEntity();
                le.setId(result.getInt("id"));
                le.setUnique_id(result.getString("unique_id"));
                le.setNama(result.getString("nama"));
                le.setEmail(result.getString("email"));
                le.setEncrypted_password(result.getString("encrypted_password"));
                le.setSalt(result.getString("salt"));
                loginEntities.add(le);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginEntities;
    }

    @Override
    public LoginEntity findByUname(String u) {
        LoginEntity loginEntity = new LoginEntity();
        String sql = "SELECT * from `tbl_user` WHERE nama = ?";
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, u);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                loginEntity.setId(result.getInt("id"));
                loginEntity.setUnique_id(result.getString("unique_id"));
                loginEntity.setNama(result.getString("nama"));
                loginEntity.setEmail(result.getString("email"));
                loginEntity.setEncrypted_password(result.getString("encrypted_password"));
                loginEntity.setSalt(result.getString("salt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginEntity;
    }
}
