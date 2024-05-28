package menu;

import gameLogic.GameLogicMulti;
import gameLogic.GameLogicSingle;
import player.Player;

import javax.swing.*;
import java.awt.*;

public class ModeMenu extends JPanel {
    public ModeMenu(Menu menu) {
        setLayout(null);
        setBackground(new Color(139, 69, 19));
        Label label = new Label("Меню");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setBounds(440, 200, 200, 50);
        add(label);

        JButton singleGameButton = new JButton("Одиночная игра");
        JButton multiplayerGameButton = new JButton("Мультиплейер");
        JButton backButton = new JButton("Назад");

        singleGameButton.setBounds(400, 300, 200, 50);
        singleGameButton.addActionListener(e -> {
            menu.getCardLayout().show(menu.getContentPane(), "singleModeMenu");

        });

        multiplayerGameButton.setBounds(400, 400, 200, 50);
        multiplayerGameButton.addActionListener(e -> {
            menu.setVisible(false);
            new GameLogicMulti(menu.getPlayer1(), menu.getPlayer2());
        });

        backButton.setBounds(400, 500, 200, 50);
        backButton.addActionListener(e -> menu.getCardLayout().show(menu.getContentPane(), "startMenu"));

        add(singleGameButton);
        add(multiplayerGameButton);
        add(backButton);
    }
}
