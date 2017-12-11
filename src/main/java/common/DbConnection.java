package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static DbConnection instance;

    private Connection connection;
    private String url = "jdbc:mariadb://localhost:3307/db_mahasiswa";
    private String username = "root";
    private String pass = "";

    private DbConnection() throws SQLException {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, pass);
            System.out.println("Database Connection Success");
        }catch (ClassNotFoundException e){
            System.out.println("Database Connection Creation Failed : " + e.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public static DbConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DbConnection();
        }else if(instance.getConnection().isClosed()){
            instance = new DbConnection();
        }

        return instance;
    }
}
