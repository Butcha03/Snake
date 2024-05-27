package GameUI;

import javax.swing.*;

public class Window extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int WINDOW_X = 300;
    private final int WINDOW_Y = 0;

    public Window(Field field) {
        setTitle("Змейка");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        setLayout(null);
        add(field);

    }
}
