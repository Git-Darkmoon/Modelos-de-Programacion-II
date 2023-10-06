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
public class Cola extends Parte implements Colisionable {
    
    public void agregarCola(){
        if(siguiente != null){
            ((Cola) siguiente).agregarCola();
        }else{
            siguiente = new Cola(this.posicion, null);
        }
    }

    public Cola(Point posicion, Parte siguiente) {
        super(posicion, siguiente);
        Juego.agregarColisionable(this);
        Juego.agregarUbicables(this);
    }
    
    @Override
    public boolean hayColision(Point posicion) {
        if(this.posicion.distance(posicion)==0){
            return true;
        }
        return false;
    }

    @Override
    public void mover() {
        
    }

    @Override
    public void mover(Point p) {
        Point aux = (Point) this.posicion.clone();
        this.posicion = (Point)p.clone();
        try{
            this.siguiente.mover(aux);
        }catch(NullPointerException e){
            //llego al final de la cola
        }
    }
    
}
