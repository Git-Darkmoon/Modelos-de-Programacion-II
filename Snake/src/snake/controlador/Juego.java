/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.controlador;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import snake.logica.Colisionable;
import snake.logica.Culebra;
import snake.logica.Parte;
import snake.logica.Ubicable;

/**
 *
 * @author Estudiantes
 */
public class Juego {
    
    static Culebra snake;
    static Random r = new Random(System.currentTimeMillis());
    static ArrayList<Colisionable> componentes = new ArrayList<>();
    public static ArrayList<Ubicable> dibujables = new ArrayList<>();
    static Dimension tab;
    public static final short DIR_ARRIBA = 0;
    public static final short DIR_DERECHA = 1;
    public static final short DIR_ABAJO = 2;
    public static final short DIR_IZQUIERDA = 3;
    public static final short FPS = 60;
    static boolean activo;
    
    public static Point posicionValida(){
        Point p = null;
        boolean valida = false;
        while(!valida){
            valida = true;
            p = new Point(r.nextInt(1,tab.width), r.nextInt(1,tab.height));
            for (Colisionable componente : componentes) {
                if(componente.hayColision(p)){
                    valida = false;
                    break;
                }
            }
        }
        return p;
    }
    
    public static void agregarColisionable(Colisionable c){
        componentes.add(c);
    }
    
    public static void agregarUbicables(Ubicable c){
        dibujables.add(c);
    }
    
    public static Dimension tamTablero(){
        return tab;
    }
    
    public static void iniciarJuego(){
        tab = new Dimension(50, 30);
        snake = new Culebra();
        snake.alimentarse();
        snake.alimentarse();
        snake.getH().setDireccion(DIR_ARRIBA);
        activo = true;
        HiloPrincipal hiloPrincipal = new HiloPrincipal();
        new Thread(hiloPrincipal, "Hilo 1").start();
    }
    
    public static void moverComponentes(){
        snake.getH().mover();
    }
    
    public static void mostrar(){
        Parte p = snake.getH();
        do{
            System.out.print(p.getPosicion()+"\t");
            p = p.getSiguiente();
        }while(p!=null);
        System.out.println("");
    }
}
