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
public class Culebra {
    
    private Cabeza h;
    
    private short velocidad;
    
    /**
     * @return the h
     */
    public Cabeza getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(Cabeza h) {
        this.h = h;
    }

    /**
     * @return the velocidad
     */
    public short getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(short velocidad) {
        this.velocidad = velocidad;
    }

    public Culebra() {
        setH(new Cabeza(Juego.DIR_DERECHA, new Point(Juego.tamTablero().width/2, Juego.tamTablero().height/2),null));
        this.velocidad = 1;
    }
    
    public void alimentarse(){
        getH().alimentarse();
    }
    
}
