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
public class Cabeza extends Parte {
    
    private short direccion;

    /**
     * @return the direccion
     */
    public short getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(short direccion) {
        this.direccion = direccion;
    }

    public Cabeza(short direccion, Point posicion, Parte siguiente) {
        super(posicion, siguiente);
        this.direccion = direccion;
        Juego.agregarUbicables(this);
    }

    @Override
    public void mover() {
        Point aux = (Point) this.posicion.clone();
        switch(this.direccion){
            case 0:
                this.posicion.y = this.posicion.y-1;
                if(this.posicion.y == 0){
                    this.posicion.y = Juego.tamTablero().height-1;
                }
                break;
            case 2:
                this.posicion.y = this.posicion.y+1;
                if(this.posicion.y == Juego.tamTablero().height){
                    this.posicion.y = 0;
                }
                break;
            case 1:
                this.posicion.x = this.posicion.x+1;
                if(this.posicion.x == Juego.tamTablero().width){
                    this.posicion.x = 0;
                }
                break;
            case 3:
                this.posicion.x = this.posicion.x-1;
                if(this.posicion.x == 0){
                    this.posicion.x = Juego.tamTablero().width-1;
                }
                break;
        }
        try{
            this.siguiente.mover(aux);
        }catch(NullPointerException e){
            
        }
    }

    @Override
    public void mover(Point p) {
        
    }
    
    public void alimentarse(){
        if(siguiente != null){
            ((Cola) siguiente).agregarCola();
        }else{
            siguiente = new Cola((Point) this.posicion.clone(), null);
        }
    }
    
}
