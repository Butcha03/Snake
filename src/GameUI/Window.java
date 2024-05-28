package GameUI;

import javax.swing.*;


public class Window extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private Field gameField;
    public Window(){
        initWindow();
        this.gameField = new Field();
        add(gameField);

    }

    public Field getGameField()
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