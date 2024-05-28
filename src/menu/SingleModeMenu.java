package menu;


import gameLogic.GameLogicClassic;
import gameLogic.GameLogicMulti;

import gameLogic.GameLogicSingle;
import player.Player;

import javax.swing.*;
import java.awt.*;

public class SingleModeMenu extends JPanel {
    public SingleModeMenu(Menu menu, Player player)
    {
        setLayout(null);
        setBackground(new Color(139, 69, 19));
        Label label = new Label("Меню");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setBounds(440, 200, 200, 50);
        add(label);

        JButton singleGameButton = new JButton("Обычный");
        JButton classicGmeButton = new JButton("Классика");
        JButton downloadButton = new JButton("Загрузить");
        JButton backButton = new JButton("Назад");

        singleGameButton.setBounds(400, 300, 200, 50);
        singleGameButton.addActionListener(e -> {
            menu.setVisible(false);
            new GameLogicSingle(new Player());

        });

        classicGmeButton.setBounds(400, 400, 200, 50);
        classicGmeButton.addActionListener(e -> {
            menu.setVisible(false);
            new GameLogicClassic(new Player());
        });

        downloadButton.setBounds(400, 500, 200, 50);
        downloadButton.addActionListener(e -> {

        });

        backButton.setBounds(400, 600, 200, 50);
        backButton.addActionListener(e -> menu.getCardLayout().show(menu.getContentPane(), "modeMenu"));

        add(singleGameButton);
        add(classicGmeButton);
        add(downloadButton);
        add(backButton);
    }
}

