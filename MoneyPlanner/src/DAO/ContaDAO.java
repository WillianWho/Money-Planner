/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.BeanConta;
import SQL.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author willi
 */
public class ContaDAO extends SQL {

    private final String banco = "mp";

    public int create(String username, String password, BeanConta c) throws ClassNotFoundException, SQLException {

        int retorno;
        con = openConnection(username, password, banco);
        stmt = con.prepareStatement("INSERT INTO `conta`(`valor`, `vencimento`, `status`, `tipo`) VALUES (?,?,?,?)");
        stmt.setDouble (1,c.getValor());
        stmt.setDate(2, c.getVencimento());
        stmt.setString(3, c.getStatus());
        stmt.setString(4,c.getTipo());
       
        if (stmt.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Os dasos foram cadastrados corretamente", "Cadastrado!", INFORMATION_MESSAGE, null);
            retorno = 1;
            closeConnection(con, stmt);
        } else {
            retorno = 0;
            closeConnection(con, stmt);
        }

        return retorno;
    }
}
