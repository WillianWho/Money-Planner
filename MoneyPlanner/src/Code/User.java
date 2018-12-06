/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import Bean.BeanUsuario;
import DAO.Select;
import Interface.Usuario;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author willi
 */
public class User implements Usuario {

    @Override
    public int atualizarPrivilegios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int remover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarUsuario(JTextField user) throws ClassNotFoundException, SQLException {
        Useful v = new Useful();
        BeanUsuario us = new BeanUsuario();
        Select select = new Select();
        us.setUsername(user.getText());
        String usuario = null;
        for(BeanUsuario u: select.select("root", "root", us)){
           usuario = u.getUsername();
       }
        if(us.getUsername().equals(usuario)){
           return v.correctField(user);
        }else{
            return v.wrongField(user);
        }
    }

    @Override
    public boolean verificarSenha(JTextField user,JPasswordField password) throws ClassNotFoundException, SQLException {
        BeanUsuario us = new BeanUsuario();
        Select select = new Select();
         Useful v = new Useful();
        
        String s = null;
       for(BeanUsuario u: select.select("root", "root",user.getText(), password.getText())){
           s = u.getPassword();
    }
       if(password.getText().equals(s)){
           return v.correctField(password);
        }else{
            return v.wrongField(password);
        }
    
}
}
