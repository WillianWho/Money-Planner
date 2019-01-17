/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

//import Bean.BeanConta;
import Bean.BeanUsuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Select extends Dao {

    /**
     *
     * @param username
     * @param password
     * @param us
     * @return retorna o username
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public ArrayList<BeanUsuario> select(String username, String password, BeanUsuario us) throws ClassNotFoundException, SQLException {
     ArrayList<BeanUsuario> u = new ArrayList<>();
     con = openConnection(username, password, banco);
     stmt = con.prepareStatement("SELECT `username`FROM `usuario` WHERE `username` =?");
     stmt.setString(1, us.getUsername());
     rs = stmt.executeQuery();
     while(rs.next()){
     us.setUsername(rs.getString("username"));
     u.add(us);
     }
      closeConnection(con, stmt);
      
     return u;
    }
    
    /**
     *
     * @param username
     * @param password
     * @param bdUser
     * @param bdSenha
     * @return retorna a senha caso os dados do usuário e senha na tela esteja de acordo com o que está no banco
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<BeanUsuario> select(String username, String password, String bdUser, String bdSenha) throws ClassNotFoundException, SQLException {
     ArrayList<BeanUsuario> u = new ArrayList<>();
     BeanUsuario us = new BeanUsuario();
     con = openConnection(username, password, banco);
     //SELECT `password`FROM `usuario` WHERE `username` = "billwho" and `password`= "root"
     stmt = con.prepareStatement("SELECT `password` FROM `usuario` WHERE `username` ='"+bdUser+"' and `password` = '"+bdSenha+"'");
     
     rs = stmt.executeQuery();
     while(rs.next()){
     
     us.setPassword(rs.getString("password"));
     u.add(us);
     }
      closeConnection(con, stmt);
      
     return u;
    }

    /**
     *
     * @param bdUser
     * @param bdSenha
     * @return nivel de privilegio do usuário
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<BeanUsuario> select(String bdUser, String bdSenha) throws ClassNotFoundException, SQLException {
     ArrayList<BeanUsuario> u = new ArrayList<>();
     BeanUsuario us = new BeanUsuario();
     con = openConnection("root", "root", banco);
     //SELECT `password`FROM `usuario` WHERE `username` = "billwho" and `password`= "root"
     stmt = con.prepareStatement("SELECT `nivelDePrivilegio` FROM `usuario` WHERE `username` ='"+bdUser+"' and `password` = '"+bdSenha+"'");
     
     rs = stmt.executeQuery();
     while(rs.next()){
     
     us.setNivelDePrivilegio(rs.getString("nivelDePrivilegio"));
     u.add(us);
     }
      closeConnection(con, stmt);
      
     return u;
    }
    
    
}
