
package snakegame.Launcher;

import snakegame.Controller.GameController;
import snakegame.Model.GameModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import snakegame.View.GameView;
import snakegame.View.NorthGamePanel;
import snakegame.View.SouthGamePanel;

/**
 *
 * @author Nicolas
 */

public class SnakeGame {

    public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {  
                GameFrame frame = new GameFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(450, 550));
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("iSnake");
                frame.getContentPane().setBackground(Color.BLACK);
            }
        });
    }
    
}

class GameFrame extends JFrame{
    
    private GameModel snakeModel;
    private GameController snakeController;
    private GameView snakeGameView;
    private NorthGamePanel northGamePanel;
    private SouthGamePanel southGamePanel;
    

    public GameFrame() {
        
        snakeGameView = new GameView();
        add(snakeGameView, BorderLayout.CENTER);
        
        snakeModel = new GameModel();
       
        northGamePanel = new NorthGamePanel();
        add(northGamePanel, BorderLayout.NORTH);
        
        southGamePanel = new SouthGamePanel();
        add(southGamePanel, BorderLayout.SOUTH);
        
        snakeController = new GameController(snakeModel, snakeGameView, northGamePanel, southGamePanel);
        
        
        
    }
    
    
    
    
}