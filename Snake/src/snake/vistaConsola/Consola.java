/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snake.vistaConsola;

import java.io.IOException;
import java.util.Arrays;
import snake.controlador.Juego;
import snake.logica.Cabeza;
import snake.logica.Cola;
import snake.logica.Ubicable;

/**
 *
 * @author Estudiantes
 */
public class Consola {

    public static void mostrarElementos() {
        String mat[][] = new String[Juego.tamTablero().height][Juego.tamTablero().width];
        for (int i = 0; i < Juego.tamTablero().height; i++) {
            Arrays.fill(mat[i], " ");
        }
        for (Ubicable d : Juego.dibujables) {
            if (d.getClass() == Cabeza.class) {
                mat[d.dondeEsta().y][d.dondeEsta().x] = "C";
            }
            if (d.getClass() == Cola.class) {
                mat[d.dondeEsta().y][d.dondeEsta().x] = "L";
            }
        }
        cls();
        for (int i = 0; i < Juego.tamTablero().height; i++) {
            for (int j = 0; j < Juego.tamTablero().width; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println("");
        }
    }

    public static void cls() {
        try {

            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

}
