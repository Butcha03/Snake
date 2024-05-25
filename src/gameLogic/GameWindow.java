package gameLogic;

import javax.swing.*;
import java.awt.*;


public class GameWindow extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    public GameWindow(){
        initWindow();
        add(new GameField());
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