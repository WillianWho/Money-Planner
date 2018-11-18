/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author willi
 */
public interface Usuario {
    public abstract int cadastrar();
    public abstract int atualizarPrivilegios();
    public abstract int remover();
}
