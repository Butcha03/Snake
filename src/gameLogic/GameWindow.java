package gameLogic;

import javax.swing.*;
import java.awt.*;


public class GameWindow extends JFrame {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private GameField gameField;
    public GameWindow(){
        initWindow();
        this.gameField = new GameField();
        add(gameField);

    }

    public GameField getGameField()
    {
        return gameField;
    }
    private void initWindow() {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

}