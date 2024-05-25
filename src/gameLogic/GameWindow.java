package gameLogic;

import javax.swing.*;
import java.awt.*;


public class GameWindow extends JFrame {
    private final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    public GameWindow(){
        initWindow();
        add(new GameFieldTest());
    }

    private void initWindow() {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}