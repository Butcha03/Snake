package GameMenu;

import javax.swing.*;
import java.awt.*;


public class Menu extends JFrame {
    private final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Menu() {
        initMenu();
        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);
        StartMenu startMenu = new StartMenu();

    }

    private void initMenu() {
        setTitle("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        getContentPane().setBackground(new Color(139, 69, 19));
        setVisible(true);
    }
}
