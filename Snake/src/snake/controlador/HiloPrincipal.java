/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import snake.vistaConsola.Consola;

/**
 *
 * @author Estudiantes
 */
public class HiloPrincipal implements Runnable {

    @Override
    public void run() {
        int mover=5;
        while(Juego.activo){
            try {
                Thread.sleep(1000/Juego.FPS);
                if(mover==0){
                    Juego.moverComponentes();
                    mover = 5;
                }
                Consola.mostrarElementos();
                mover--;
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
