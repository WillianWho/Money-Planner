/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageTest;

import Bean.BeanConta;
import Bean.BeanUsuario;
import DAO.Dao;
import DAO.Select;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author willi
 */
public class TesteClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /*testClassDAOInsert(22.5f,"2018-02-09","pago", "teste da classe DAO" );
            testClassDAOUpdate(1,22.5f,"2018-02-09","pendente", "teste update class DAO" );
            testClassDAODelete(1,"conta");
            testClassDAOInsert("billwho","root","willian","root");
            testClassDAOUpdate(1,"billwho","root","willian","guest");
            testClassDAODelete(1,"user");*/
            System.out.println(testNewSelect("billwho","root"));
        } catch (/*ParseException |*/ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro", INFORMATION_MESSAGE, null);
        }
    }
    private static String testeClassSelect(String username) throws ClassNotFoundException, SQLException{
        BeanUsuario us = new BeanUsuario();
        Select select = new Select();
        us.setUsername(username);
        String user = null;
       for(BeanUsuario u: select.select("root", "root", us)){
           user = u.getUsername();
       }
        
        /*Select.select("root", "root", us).forEach((BeanUsuario u->){
        u.getUsername();
        });*/
        
        return user;
    }
    private static String testNewSelect(String usuario, String senha) throws ClassNotFoundException, SQLException{
        BeanUsuario us = new BeanUsuario();
        Select select = new Select();
        
        String s = null;
       for(BeanUsuario u: select.select("root", "root",usuario, senha)){
          
           s = u.getPassword();
       }
       return "Senha: "+s;
    }

   
    private static void testClassDAOInsert(double valor, String vencimento, String status, String tipo) throws ParseException, ClassNotFoundException, SQLException {
        Dao dao = new Dao();
        BeanConta c = new BeanConta();
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = new java.sql.Date(fmt.parse(vencimento).getTime());
        c.setStatus(status);
        c.setTipo(tipo);
        c.setValor(valor);
        c.setVencimento(data);
        dao.insert("root", "root", c);
    }

    private static void testClassDAOInsert(String username, String password, String nomeCompleto, String nivelDePrivilegio) throws ParseException, ClassNotFoundException, SQLException {
        Dao dao = new Dao();
        BeanUsuario u = new BeanUsuario();
        u.setUsername(username);
        u.setPassword(password);
        u.setNomeCompleto(nomeCompleto);
        u.setNivelDePrivilegio(nivelDePrivilegio);
        dao.insert("root", "root", u);
    }

    private static void testClassDAOUpdate(int PK_ID, double valor, String vencimento, String status, String tipo) throws ParseException, ClassNotFoundException, SQLException {
        Dao dao = new Dao();
        BeanConta c = new BeanConta();
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date data = new java.sql.Date(fmt.parse(vencimento).getTime());
        c.setStatus(status);
        c.setTipo(tipo);
        c.setValor(valor);
        c.setVencimento(data);
        c.setPK_ID(PK_ID);
        dao.update("root", "root", c);
    }

    private static void testClassDAOUpdate(int PK_ID, String username, String password, String nomeCompleto, String nivelDePrivilegio) throws ParseException, ClassNotFoundException, SQLException {
        Dao dao = new Dao();
        BeanUsuario u = new BeanUsuario();
        u.setUsername(username);
        u.setPassword(password);
        u.setNomeCompleto(nomeCompleto);
        u.setNivelDePrivilegio(nivelDePrivilegio);
        u.setPK_ID(PK_ID);
        dao.update("root", "root", u);
    }

    private static void testClassDAODelete(int PK_ID, String option) throws ClassNotFoundException, SQLException {
        Dao dao = new Dao();
        switch (option) {
            case "user":
                BeanUsuario u = new BeanUsuario();

                u.setPK_ID(PK_ID);
                dao.delete("root", "root", u);
                break;
            case "conta":
                BeanConta c = new BeanConta();
                c.setPK_ID(PK_ID);
                dao.delete("root", "root", c);
                break;
            default:
                JOptionPane.showMessageDialog(null, "opção incorreta", "Delete", INFORMATION_MESSAGE, null);
        }

    }

}
