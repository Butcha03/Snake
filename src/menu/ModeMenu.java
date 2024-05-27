package menu;

import gameLogic.GameLogicMulti;
import gameLogic.GameLogicSolo;
import gameLogic.GameWindow;
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

        JButton soloGameButton = new JButton("Одиночная игра");
        JButton multiplayerGameButton = new JButton("Мультиплейер");
        JButton backButton = new JButton("Назад");

        soloGameButton.setBounds(400, 300, 200, 50);
        soloGameButton.addActionListener(e -> {
            menu.setVisible(false);
            new GameLogicSolo(new Player());

        });

        multiplayerGameButton.setBounds(400, 400, 200, 50);
        multiplayerGameButton.addActionListener(e -> {
            menu.setVisible(false);
            new GameLogicMulti(new Player(), new Player());
        });

        backButton.setBounds(400, 500, 200, 50);
        backButton.addActionListener(e -> menu.getCardLayout().show(menu.getContentPane(), "startMenu"));

        add(soloGameButton);
        add(multiplayerGameButton);
        add(backButton);
    }
}
