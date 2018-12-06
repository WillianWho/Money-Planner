/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.BeanConta;
import Bean.BeanUsuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public interface CRUD {
    public abstract int insert(String username, String password, BeanUsuario u)throws ClassNotFoundException, SQLException;
    public abstract int insert(String username, String password, BeanConta c) throws ClassNotFoundException, SQLException;
    public abstract int update(String username, String password, BeanUsuario u) throws ClassNotFoundException, SQLException;
    public abstract int update(String username, String password, BeanConta c) throws ClassNotFoundException, SQLException;
    public abstract int delete(String username, String password, BeanUsuario u) throws ClassNotFoundException, SQLException;
    public abstract int delete(String username, String password, BeanConta c) throws ClassNotFoundException, SQLException;
   
    public abstract ArrayList select(String username, String password, BeanUsuario c)throws ClassNotFoundException, SQLException;
}
