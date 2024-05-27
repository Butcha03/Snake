package menu;

import gameLogic.GameWindow;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private int menuWidth = 1000;
    private int menuHeight = 800;
    private int menuX = 300;
    private int menuY = 0;
    private StartMenu startMenu;
    private ModeMenu modeMenu;
    private OptionMenu optionMenu;
    private CardLayout cardLayout;
    private Player player1;
    private Player player2;

    public Menu(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        setTitle("Змеийка");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(menuX, menuY, menuWidth, menuHeight);
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        startMenu = new StartMenu(this);
        add(startMenu, "startMenu");

        modeMenu = new ModeMenu(this);
        add(modeMenu, "modeMenu");

        optionMenu = new OptionMenu(this);
        add(optionMenu, "optionMenu");

        cardLayout.show(getContentPane(), "startMenu");
        setVisible(true);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }


    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
