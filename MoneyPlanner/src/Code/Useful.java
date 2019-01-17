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
import javax.swing.JFormattedTextField;

/**
 *
 * @author willi
 */
public class Useful {

    private final LineBorder vermelhoEscuro = new LineBorder(new Color(238, 0, 0));
    private final LineBorder verdeEscuro = new LineBorder(new Color(0, 238, 0));

    private boolean comfirmField(JPasswordField stringA, JPasswordField stringB) {
        return stringA.getText().equals(stringB.getText());
    }

    /**
     *
     * @param field
     * @return false caso o campo esteja vazio, true caso não
     */
    public boolean validateField(JTextField field) {
        if (field.getText().equals("")) {
            field.setBorder(this.vermelhoEscuro);
            return false;
        } else {
            field.setBorder(this.verdeEscuro);
            return true;
        }
    }

    public boolean validateField(JFormattedTextField field) {
        switch (field.getText()) {
            case "":
                field.setBorder(this.vermelhoEscuro);
                return false;
            case "  ":
                field.setBorder(this.vermelhoEscuro);
                return false;
            case "    ":
                field.setBorder(this.vermelhoEscuro);
                return false;
            default:
                field.setBorder(this.verdeEscuro);
                return true;
        }
    }

    /**
     *
     * @param stringA
     * @param stringB
     * @return true se os campos forem válidos false se não forem
     */
    public boolean validateField(JPasswordField stringA, JPasswordField stringB) {
        if (this.comfirmField(stringA, stringB)) {
            stringB.setBorder(this.verdeEscuro);
            return true;
        } else {
            stringB.setBorder(this.vermelhoEscuro);
            return false;
        }
    }

    /**
     *
     * @param field
     * @return true se os campos forem válidos false se não forem
     */
    public boolean validateField(JPasswordField field) {
        if (field.getText().equals("")) {
            field.setBorder(this.vermelhoEscuro);
            return false;
        } else {
            field.setBorder(this.verdeEscuro);
            return true;
        }
    }

    /**
     *
     * @param field
     * @return false
     */
    public boolean wrongField(JPasswordField field) {
        field.setBorder(this.vermelhoEscuro);
        return false;
    }

    /**
     *
     * @param field
     * @return false
     */
    public boolean wrongField(JTextField field) {
        field.setBorder(this.vermelhoEscuro);
        return false;
    }

    /**
     *
     * @param field
     * @return true
     */
    public boolean correctField(JPasswordField field) {
        field.setBorder(this.verdeEscuro);
        return true;
    }

    /**
     *
     * @param field
     * @return true
     */
    public boolean correctField(JTextField field) {
        field.setBorder(this.verdeEscuro);
        return true;
    }

    /**
     *
     * @param dia
     * @param mes
     * @param ano
     * @param formato
     * @return formatação brasileira ou americana ou null em caso de erro
     */
    public String dateFormat(String dia, String mes, String ano, String formato) {
        String date;
        switch (formato) {
            case "br":
                return date = dia + "/" + mes + "/" + ano;
            case "us":
                return date = ano + "-" + mes + "-" + dia;
            default:
                return null;
        }

    }
}
