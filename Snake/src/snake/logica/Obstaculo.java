/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.logica;

import java.awt.Point;
import snake.controlador.Juego;

/**
 *
 * @author Estudiantes
 */
public class Obstaculo implements Colisionable {
    
    private Point posicion;

    /**
     * @return the posicion
     */
    public Point getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean hayColision(Point posicion) {
        if(this.posicion.distance(posicion)==0){
            return true;
        }
        return false;
    }

    public Obstaculo(Point posicion) {
        this.posicion = posicion;
        Juego.agregarColisionable(this);
    }
    
    
    
}
