
package snakegame.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Nicolas
 */

public class SouthGamePanel extends JPanel {
         
    private final JLabel scorelabel;
    private final JLabel lives;
    
    private final Color txtColor = new Color(182, 182, 182);
    
    private final Font fontFamily = new Font("Verdana", Font.PLAIN, 18);

    public SouthGamePanel() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(0, 2));
        
        scorelabel = new JLabel();
        scorelabel.setForeground(txtColor);
        setScoreLabel(0);
        scorelabel.setFont(fontFamily);
        scorelabel.setPreferredSize(new Dimension(100, 30));
        add(scorelabel);
        
        lives = new JLabel("", SwingConstants.RIGHT);
        lives.setForeground(txtColor);
        setLivesLabel(3);
        lives.setFont(fontFamily);
        lives.setPreferredSize(new Dimension(100, 30));
        add(lives);
        
    }
    
    public void setScoreLabel(int score){
    scorelabel.setText(" Score: "+ score);
    }
    
    public void setLivesLabel(int live){
    lives.setText("Lives: "+ live+" ");
    }
}
