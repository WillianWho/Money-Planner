/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.BeanUsuario;
import SQL.Sql;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author willi
 */
public class UsuarioDAO extends Sql {

    private final String banco = "mp";

    public int insert(String username, String password, BeanUsuario u) throws ClassNotFoundException, SQLException {
        int retorno;
        con = openConnection(username, password, banco);
        stmt = con.prepareStatement("INSERT INTO `usuario`( `nomeCompleto`, `username`, `password`, `nivelDePrivilegio`) VALUES (?,?,?,?)");
        stmt.setString(1, u.getNomeCompleto());
        stmt.setString(2, u.getUsername());
        stmt.setString(3, u.getPassword());
        stmt.setString(4, u.getNivelDePrivilegio());
        if (stmt.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Os dasos foram cadastrados corretamente", "Insert", INFORMATION_MESSAGE, null);
            retorno = 1;
            closeConnection(con, stmt);
        } else {
            retorno = 0;
            closeConnection(con, stmt);
        }
        return retorno;
    }

    public int update(String username, String password, BeanUsuario u) throws ClassNotFoundException, SQLException {
        int retorno;
        con = openConnection(username, password, banco);
        stmt = con.prepareStatement("UPDATE `usuario` SET `nomeCompleto`=?,`username`=?,`password`=?,`nivelDePrivilegio`=? WHERE `PK_ID`=?;");
        stmt.setString(1, u.getNomeCompleto());
        stmt.setString(2, u.getUsername());
        stmt.setString(3, u.getPassword());
        stmt.setString(4, u.getNivelDePrivilegio());
        stmt.setInt(5, u.getPK_ID());
        if (stmt.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null, "Os dasos foram atualizados corretamente", "Update", INFORMATION_MESSAGE, null);
            retorno = 1;
            closeConnection(con, stmt);
        } else {
            retorno = 0;
            closeConnection(con, stmt);
        }
        return retorno;
    }
    public int delete(String username, String password, BeanUsuario u ) throws ClassNotFoundException, SQLException{
        int retorno;
        con = openConnection(username,password,banco);
        stmt = con.prepareStatement("DELETE FROM `usuario` WHERE PK_ID = ?");
        stmt.setInt(1, u.getPK_ID());
        if(stmt.executeUpdate()!=0){
            JOptionPane.showMessageDialog(null, "Os dasos foram apagados corretamente", "Delete", INFORMATION_MESSAGE, null);
            retorno = 1;
        }else{
            retorno =0;
        }
        return retorno;
    } 

}
