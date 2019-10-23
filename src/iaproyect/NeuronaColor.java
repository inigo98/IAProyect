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
public class NeuronaColor {
    ArrayList<String> colores = new ArrayList();
    NeuronaMotores neurona_motores = new NeuronaMotores();
    public String NeuronaColorDatos(int ladoCorto, int ladoValor, int colorFront, int colorBack){
        if(this.colores.size() == 0){
            this.colores.add("F" + colorFront);
            this.colores.add("B" + colorBack);
        } else {
            if( this.search("F" + colorFront) != 1){
                this.colores.add("F" + colorFront);
            }
            if( this.search("B" + colorBack) != 1){
                this.colores.add("B" + colorBack);
            }
        }
        return this.Process(ladoCorto, ladoValor, colorFront, colorBack);
    }
    public int search(String valor){
        for(String value: this.colores ){
            if( valor.equals(value) ){
                return 1;
            }
        }
        return 0;
    }
    public String Process(int ladoCorto, int ladoValor, int colorFront, int colorBack){
        // primero 4 parametros
        
        // 0 no hace nada el motor
        // 1 avanza adelante
        // 2 avanza atras
        
        // ultimo parametro
        // 0 100 ms de retardo
        // 1 1000 ms de retardo
        // 2 2000 ms de retardo
        if( (colorFront == 0) && (colorBack == 0)){
            // sigue en la pista
            switch(ladoCorto) {
                case 1:
                  // menor distancia del lado izquierdo
                    return this.neurona_motores.NeuronaMotorDatos(1, 2, 1, 2, 2);
                case 2:
                  // menor distancia del lado derecho
                    return this.neurona_motores.NeuronaMotorDatos(2, 1, 2, 1, 2);
                case 3:
                  // menor distancia al frente
                    return this.neurona_motores.NeuronaMotorDatos(1, 1, 1, 1, 1);
                case 4:
                  // menor distancia atras
                    return this.neurona_motores.NeuronaMotorDatos(2, 2, 2, 2, 1);
            }
        }
        if( (colorFront == 0) && (colorBack == 1)){
            //  esta saliendo de la pista por atras
            switch(ladoCorto) {
                case 1:
                  // menor distancia del lado izquierdo
                    return this.neurona_motores.NeuronaMotorDatos(1, 2, 1, 2, 2);
                case 2:
                  // menor distancia del lado derecho
                    return this.neurona_motores.NeuronaMotorDatos(2, 1, 2, 1, 2);
                case 3:
                  // menor distancia al frente
                    return this.neurona_motores.NeuronaMotorDatos(1, 1, 1, 1, 2);
                case 4:
                  // menor distancia atras
                    return this.neurona_motores.NeuronaMotorDatos(2, 2, 2, 2, 0);
            }
        }
        if( (colorFront == 1) && (colorBack == 0)){
            // esta saliendo de la pista por delante
            switch(ladoCorto) {
                case 1:
                  // menor distancia del lado izquierdo
                    return this.neurona_motores.NeuronaMotorDatos(2, 0, 2, 2, 1);
                case 2:
                  // menor distancia del lado derecho
                    return this.neurona_motores.NeuronaMotorDatos(0, 2, 2, 2, 1);
                case 3:
                  // menor distancia al frente
                    return this.neurona_motores.NeuronaMotorDatos(1, 1, 1, 1, 0);
                case 4:
                  // menor distancia atras
                    return this.neurona_motores.NeuronaMotorDatos(2, 2, 2, 2, 1);
            }
        }
        if( (colorFront == 1) && (colorBack == 1)){
            // esta saliendo de la pista de lado
            switch(ladoCorto) {
                case 1:
                  // menor distancia del lado izquierdo
                    return this.neurona_motores.NeuronaMotorDatos(1, 0, 1, 1, 0);
                case 2:
                  // menor distancia del lado derecho
                    return this.neurona_motores.NeuronaMotorDatos(0, 1, 1, 1, 0);
                case 3:
                  // menor distancia al frente
                    return this.neurona_motores.NeuronaMotorDatos(1, 1, 1, 1, 0);
                case 4:
                  // menor distancia atras
                    return this.neurona_motores.NeuronaMotorDatos(2, 2, 2, 2, 0);
            }
        }
        return "";
    }
}
