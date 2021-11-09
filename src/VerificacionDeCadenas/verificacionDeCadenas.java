/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VerificacionDeCadenas;

/**
 *
 * @author Martin
 */
public class verificacionDeCadenas {

    public static boolean verificacionDni(String cadena) {
        if (cadena.length() == 8) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esVacia(String cadena){
        if(cadena.isEmpty()||(cadena.trim().equals(""))){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static Integer longitudCadena(String cadena){
        return cadena.length();
    }
}
