/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.ResourceBundle;

/**
 *
 * @author idomar
 */
public class Config {

    public static final ResourceBundle i18n
            = ResourceBundle.getBundle(
                    String.format("i18n.Bundle_%s", "pt_BR"));

    public static final char INCLUIR = 'I';
    public static final char ALTERAR = 'A';
    public static final char EXCLUIR = 'E';

}
