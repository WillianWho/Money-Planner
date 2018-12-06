/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author willi
 */
public interface Usuario {
    public abstract int atualizarPrivilegios();
    public abstract boolean verificarUsuario(JTextField user)throws ClassNotFoundException, SQLException;
    public abstract boolean verificarSenha(JTextField user,JPasswordField password)throws ClassNotFoundException, SQLException;
    public abstract int remover();
}
