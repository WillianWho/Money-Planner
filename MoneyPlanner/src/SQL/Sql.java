/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author willi
 */
public class Sql{

    protected Connection con = null;
    protected PreparedStatement stmt = null;
    protected ResultSet rs = null;

    /**
     *
     * @param username
     * @param password
     * @param dataBase
     * @return retorna a conexão
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected static Connection openConnection(String username, String password, String dataBase) throws ClassNotFoundException, SQLException {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/" + dataBase;
        Class.forName(driver);
        con = DriverManager.getConnection(url, username, password);
        return con;
    }

    private static void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    /**
     *
     * @param con
     * @param stmt
     * @throws SQLException
     */
    protected static void closeConnection(Connection con, PreparedStatement stmt) throws SQLException {
        closeConnection(con);
        stmt.close();
    }
}
