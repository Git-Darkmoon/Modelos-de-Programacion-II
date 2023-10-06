
package snakegame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Nicolas
 */

public class GameView extends JComponent {
    
    private Cell[][] snakeGame;
    private final int boardHeight = 400;
    private final int boardWidth = 400;
    
    private final Color snakeColor = new Color(119,221,119);
    private final Color fruitColor = new Color(220,20,60);
    private final Color bgBoardColor = new Color(17,24,35);
    private final Color borderBoardColor = new Color(244,180,251);
    
    
    public GameView(){ }

    public void addKeyArrowListener(int keyCode, String Name, Action action){
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0), Name);
        getActionMap().put(Name, action);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        for (int i = 0; i<snakeGame.length; i++){
            for (int j = 0; j < snakeGame[i].length; j++) {
                if (snakeGame[i][j].isSnake()) {
                    g2d.setColor(snakeColor);
                } else if (snakeGame[i][j].isFruit()) {
                    g2d.setColor(fruitColor);
                }
                else{
                    g2d.setColor(bgBoardColor);
                }
                g2d.fill(snakeGame[i][j].getCircle());
            }
        }
        
        g2d.setColor(borderBoardColor);
        //+20 is just to put some space from the border :v
        g2d.drawRect(0+20, 0+20, boardWidth, boardHeight);
    }
    
    public void setCells(Cell[][] allCells){
        this.snakeGame = allCells;
    }
    
    public Cell[][] getCells(){return snakeGame;}
            
}
