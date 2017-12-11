package common;

import static org.junit.Assert.*;

public class DbConnectionTest {
    @org.junit.Test
    public void getConnection() throws Exception {
        System.out.println(DbConnection.getInstance().getConnection());
    }
}