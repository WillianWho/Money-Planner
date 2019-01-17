/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import Bean.BeanConta;
import Bean.BeanUsuario;
import DAO.Dao;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author willi
 */
public class Cadastrar {

    public int newUserRoot(JTextField fullName, JTextField username, JPasswordField password) throws ClassNotFoundException, SQLException {
        BeanUsuario u = new BeanUsuario();
        Dao dao = new Dao();
        u.setNomeCompleto(fullName.getText());
        u.setUsername(username.getText());
        u.setPassword(password.getText());
        u.setNivelDePrivilegio("root");
        return dao.insert("root", "root", u);
    }

    public int novaConta(String valor, String tipo, String vencimento, String status) throws ClassNotFoundException, SQLException {
        BeanConta nc = new BeanConta();
        Dao dao = new Dao();

        nc.setValor(Double.parseDouble(status));
        nc.setTipo(tipo);
        nc.setVencimento(vencimento);
        nc.setStatus(status);
        return dao.insert("root", "root", nc);
    }
}
