/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaproyect;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author navar
 */
public class IAProyect extends JFrame implements ActionListener{

    JButton start;
    JTextArea variables;
    JScrollPane scrollVariables;
    boolean startRobot = false;
    int ultrasonicFront, ultrasonicBack, ultrasonicLeft, ultrasonicRight, colorFront, colorBack;
    NeuronaUltrasonic neurona_ultrasonic = new NeuronaUltrasonic();
    public IAProyect() {
        this.setBounds(0, 0, 1370, 800);
        this.setVisible(true);
        this.setLayout(null);
        start = new JButton();
        start.setName("START");
        start.setText("START");
        start.setBounds(25, 25, 150, 25);
        start.setVisible(true);
        start.addActionListener(this);
        this.add(start);
        variables = new JTextArea();
        variables.setName("Nodos");
        variables.setText("");
        variables.setEditable(false);
        variables.setBounds(25, 100, 380, 650);
        variables.setVisible(true);
        this.add(variables);
        scrollVariables = new JScrollPane(variables);
        scrollVariables.setBounds(25, 100, 380, 650);
        this.add(scrollVariables);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new IAProyect().show();
    }
        
    public void Lectura(){
        // datos del arduino
        this.ultrasonicFront = 200;
        this.ultrasonicBack = 2000;
        this.ultrasonicLeft = 2000;
        this.ultrasonicRight = 2000;
        this.colorFront = 1;
        this.colorBack = 1;
    }
    
    public void Escritura(char motorFrontRight, char motorFrontLeft, char motorBackRight, char motorBackLeft){
        // mandar datos al arduino
    }
    
    public void Entradas() throws InterruptedException{
        this.Lectura();
        String ejecutar = this.neurona_ultrasonic.NeuronaUltrasonicDatos(this.ultrasonicFront, this.ultrasonicBack, this.ultrasonicLeft, this.ultrasonicRight, this.colorFront, this.colorBack);
        this.Descomprimir(ejecutar);
    }
    
    public void Descomprimir(String text) throws InterruptedException{
        char motorFrontRight = text.charAt(0);
        char motorFrontLeft = text.charAt(1);
        char motorBackRight = text.charAt(2);
        char motorBackLeft = text.charAt(3);
        char retardo = text.charAt(4);
        this.Escritura(motorFrontRight, motorFrontLeft, motorBackRight, motorBackLeft);
        System.out.println(text);
        if(retardo == '0'){
            Thread.sleep(100);
            this.Entradas();
        }
        if(retardo == '1'){
            Thread.sleep(1000);
            this.Entradas();
        }
        if(retardo == '2'){
            Thread.sleep(2000);
            this.Entradas();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            try {
                this.Entradas();
            } catch (InterruptedException ex) {
                Logger.getLogger(IAProyect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
