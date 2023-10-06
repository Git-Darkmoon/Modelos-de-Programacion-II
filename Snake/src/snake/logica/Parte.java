/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.logica;

import java.awt.Point;

/**
 *
 * @author Estudiantes
 */
public abstract class Parte implements Movible, Ubicable{
    
    protected Point posicion;
    protected Parte siguiente;

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

    /**
     * @return the siguiente
     */
    public Parte getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Parte siguiente) {
        this.siguiente = siguiente;
    }

    public Parte(Point posicion, Parte siguiente) {
        this.posicion = posicion;
        this.siguiente = siguiente;
    }
    
    @Override
    public Point dondeEsta() {
        return getPosicion();
    }
    
}
