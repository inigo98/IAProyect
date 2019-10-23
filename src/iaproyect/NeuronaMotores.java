/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyect;

import java.util.ArrayList;

/**
 *
 * @author navarret
 */
public class NeuronaMotores {
    ArrayList<String> motores = new ArrayList();
    public String NeuronaMotorDatos(int motorFrontRight, int motorFrontLeft, int motorBackRight, int motorBackLeft, int retardo){
        String numero = String.valueOf(motorFrontRight) + String.valueOf(motorFrontLeft) + String.valueOf(motorBackRight) + String.valueOf(motorBackLeft) + String.valueOf(retardo);
        this.motores.add(numero);
        return numero;
    }
}
