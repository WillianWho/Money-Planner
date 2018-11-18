/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageTest;

import Bean.BeanConta;
import Bean.BeanUsuario;
import DAO.ContaDAO;
import DAO.UsuarioDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author willi
 */
public class TesteClass {

    public static void testarCadastro() throws ParseException, ClassNotFoundException, SQLException {
        Date sqlDate;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = new java.sql.Date(fmt.parse("2018-11-11").getTime());

        ContaDAO conta = new ContaDAO();
        BeanConta c = new BeanConta();
        c.setStatus("pago");
        c.setTipo("Água");
        c.setValor(22);
        c.setVencimento(data);
        conta.insert("root", "root", c);
    }

    public static void testarUpdate() throws ParseException, ClassNotFoundException, SQLException {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = new java.sql.Date(fmt.parse("2020-11-11").getTime());
        ContaDAO conta = new ContaDAO();
        BeanConta c = new BeanConta();
        c.setStatus("pago");
        c.setTipo("Luz");
        c.setValor(50);
        c.setVencimento(data);
        c.setPK_ID(1);
        conta.update("root", "root", c);
    }

    public static void testarDelete() throws ParseException, ClassNotFoundException, SQLException {
        ContaDAO conta = new ContaDAO();
        BeanConta c = new BeanConta();

        c.setPK_ID(1);
        conta.delete("root", "root", c);
    }

    public static void testarUserInsert() throws ClassNotFoundException, SQLException{
        UsuarioDAO user = new UsuarioDAO();
        BeanUsuario u = new BeanUsuario();
        u.setUsername("BillWho");
        u.setPassword("root");
        u.setNomeCompleto("Willian");
        u.setNivelDePrivilegio("root");
        user.insert("root", "root", u);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //testarCadastro();
            //testarUpdate();
            //testarDelete();
            testarUserInsert();
        } catch (/*ParseException |*/ ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro", INFORMATION_MESSAGE, null);
        }
    }

}
