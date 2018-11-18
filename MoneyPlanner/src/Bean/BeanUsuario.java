/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author willi
 */
public class BeanUsuario {
    private int PK_ID;
    private String nomeCompleto;
    private String username;
    private String password;
    private String nivelDePrivilegio;
    

    public String getNome() {
        return nomeCompleto;
    }

    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return username;
    }

    public void setEmail(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getNivelDePrivilegio() {
        return nivelDePrivilegio;
    }

    public void setNivelDePrivilegio(String nivelDePrivilegio) {
        this.nivelDePrivilegio = nivelDePrivilegio;
    }

    public int getPK_ID() {
        return PK_ID;
    }

    public void setPK_ID(int PK_ID) {
        this.PK_ID = PK_ID;
    }
    
}
