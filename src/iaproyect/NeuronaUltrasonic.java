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
public class NeuronaUltrasonic {
    ArrayList<String> ultrasonicos = new ArrayList();
    NeuronaColor neurona_color = new NeuronaColor();
    public String NeuronaUltrasonicDatos(int ultrasonicFront, int ultrasonicBack, int ultrasonicLeft, int ultrasonicRight, int colorFront, int colorBack){
        if(this.ultrasonicos.size() == 0){
            this.ultrasonicos.add("F" + ultrasonicFront);
            this.ultrasonicos.add("B" + ultrasonicBack);
            this.ultrasonicos.add("L" + ultrasonicLeft);
            this.ultrasonicos.add("R" + ultrasonicRight);
        } else {
            if( this.search("F" + ultrasonicFront) != 1){
                this.ultrasonicos.add("F" + ultrasonicFront);
            }
            if( this.search("B" + ultrasonicBack) != 1){
                this.ultrasonicos.add("B" + ultrasonicBack);
            }
            if( this.search("L" + ultrasonicLeft) != 1){
                this.ultrasonicos.add("L" + ultrasonicLeft);
            }
            if( this.search("R" + ultrasonicRight) != 1){
                this.ultrasonicos.add("R" + ultrasonicRight);
            }
        }
        return this.Process(ultrasonicFront, ultrasonicBack, ultrasonicLeft, ultrasonicRight, colorFront, colorBack);
    }
    public int search(String valor){
        for(String value: this.ultrasonicos ){
            if( valor.equals(value) ){
                return 1;
            }
        }
        return 0;
    }
    public String Process(int ultrasonicFront, int ultrasonicBack, int ultrasonicLeft, int ultrasonicRight, int colorFront, int colorBack){
        if( (ultrasonicLeft < ultrasonicFront) && (ultrasonicLeft < ultrasonicBack) && (ultrasonicLeft < ultrasonicRight) ){
            // menor distancia del lado izquierdo
            return this.neurona_color.NeuronaColorDatos(1, ultrasonicLeft,  colorFront, colorBack);
        }
        if( (ultrasonicRight < ultrasonicFront) && (ultrasonicRight < ultrasonicBack) && (ultrasonicRight < ultrasonicLeft) ){
            // menor distancia del lado derecho
            return this.neurona_color.NeuronaColorDatos(2, ultrasonicRight, colorFront, colorBack);
        }
        if( (ultrasonicFront < ultrasonicLeft) && (ultrasonicFront < ultrasonicBack) && (ultrasonicFront < ultrasonicRight) ){
            // menor distancia al frente
            return this.neurona_color.NeuronaColorDatos(3, ultrasonicFront, colorFront, colorBack);
        }
        if( (ultrasonicBack < ultrasonicFront) && (ultrasonicBack < ultrasonicLeft) && (ultrasonicBack < ultrasonicRight) ){
            // menor distancia atras
            return this.neurona_color.NeuronaColorDatos(4, ultrasonicBack, colorFront, colorBack);
        }
        return "";
    }
}
