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
public class Comida implements Colisionable{
    
    private Point posicion;
    private boolean alimento;
    private int puntos;
    
    
    public static final short tiempoEnTablero = 7000;

    /**
     * @return the alimento
     */
    public boolean isAlimento() {
        return alimento;
    }

    /**
     * @param alimento the alimento to set
     */
    public void setAlimento(boolean alimento) {
        this.alimento = alimento;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Comida(int puntos) {
        this.puntos = puntos;
        this.alimento = false;
        this.posicion = Juego.posicionValida();
        Juego.agregarColisionable(this);
    }

    public Comida(boolean alimento, int puntos) {
        this.alimento = alimento;
        this.puntos = puntos;
        this.posicion = Juego.posicionValida();
        Juego.agregarColisionable(this);
    }

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
    
}
