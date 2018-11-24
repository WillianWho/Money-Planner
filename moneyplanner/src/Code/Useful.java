/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author willi
 */
public class Useful {

    private LineBorder vermelhoEscuro = new LineBorder(new Color(238, 0, 0));
    private LineBorder verdeEscuro = new LineBorder(new Color(0, 238, 0));

    private boolean comfirmField(JPasswordField stringA, JPasswordField stringB) {
        return stringA.getText().equals(stringB.getText());
    }

    public boolean validateField(JTextField field) {
        if (field.getText().equals("")) {
            field.setBorder(this.vermelhoEscuro);
            return false;
        } else {
            field.setBorder(this.verdeEscuro);
            return true;
        }
    }

    public boolean validateField(JPasswordField stringA, JPasswordField stringB) {
        if(this.comfirmField(stringA, stringB)){
            stringB.setBorder(this.verdeEscuro);
            return true;
        }else{
         stringB.setBorder(this.vermelhoEscuro); 
         return false;
        }
    }
    public boolean validateField(JPasswordField field) {
        if (field.getText().equals("")) {
            field.setBorder(this.vermelhoEscuro);
            return false;
        } else {
            field.setBorder(this.verdeEscuro);
        return true;
        }
    }

}
