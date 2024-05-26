package menu;

import gameLogic.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel startMenu;
    private JPanel modeMenu;
    private CardLayout cardLayout;

    public Menu() {
        setTitle("Змеийка");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(300,0);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        startMenu = new StartMenu(this);
        add(startMenu, "startMenu");

        modeMenu = new ModeMenu(this);
        add(modeMenu, "modeMenu");

        cardLayout.show(getContentPane(), "startMenu");
        setSize(1000, 800);
        setVisible(true);
    }

    private void CenterAlignment() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
