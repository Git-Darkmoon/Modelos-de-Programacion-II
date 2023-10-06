package snakegame.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas
 */
public class NorthGamePanel extends JPanel {

    private final JButton startGameBtn;
    private final JButton newGameBtn;

    private final int btnWidth = 150;
    private final int btnHeight = 30;

    private final Color btnBg = new Color(17, 24, 35);
    private final Color btnTxtColor = new Color(112, 128, 144);

    private final Font fontFamily = new Font("Verdana", Font.PLAIN, 14);

    public NorthGamePanel() {
        setBackground(Color.BLACK);

        startGameBtn = new JButton("Start");
        startGameBtn.setBackground(btnBg);
        startGameBtn.setForeground(btnTxtColor);
        startGameBtn.setFocusable(false);
        startGameBtn.setFont(fontFamily);
        startGameBtn.setPreferredSize(new Dimension(btnWidth, btnHeight));
        add(startGameBtn);

        newGameBtn = new JButton("New Game");
        newGameBtn.setBackground(btnBg);
        newGameBtn.setForeground(btnTxtColor);
        newGameBtn.setFocusable(false);
        newGameBtn.setFont(fontFamily);
        newGameBtn.setPreferredSize(new Dimension(btnWidth, btnHeight));
        add(newGameBtn);

    }

    public void addPlayButtonListener(ActionListener playAction) {
        startGameBtn.addActionListener(playAction);
    }

    public void addNewGameButoonListener(ActionListener newGameAction) {
        newGameBtn.addActionListener(newGameAction);
    }

    public void updatePanelForPlayMode(boolean isPlaying) {
        if (isPlaying) {
            newGameBtn.setEnabled(false);
            startGameBtn.setText("Pause");
        } else {
            newGameBtn.setEnabled(true);
            startGameBtn.setText("Play");
        }
    }

    public void updatePanelForGameOverMode() {
        newGameBtn.setEnabled(true);
        startGameBtn.setEnabled(false);
    }

    public void updatePanelforGameStartMode() {
        newGameBtn.setEnabled(true);
        startGameBtn.setEnabled(true);
    }
}
