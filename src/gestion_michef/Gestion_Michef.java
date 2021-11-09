/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_michef;

import Formularios.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Martin
 */
import javax.swing.Timer;
public class Gestion_Michef {

    public static frm_InicioSesion Inicio;
    public static Frm_pantallaInicio Pantallazo;

    public static void main(String[] args) {
        Pantallazo = new Frm_pantallaInicio();
        Pantallazo.setVisible(true);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pantallazo.dispose();
        Inicio = new frm_InicioSesion();
        Inicio.setVisible(true);
    }

}
