package menu;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JPanel {
    public StartMenu(Menu menu) {
        setLayout(null);
        setBackground(new Color(139, 69, 19));

        Label label = new Label("Меню");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setBounds(440, 200, 200, 50);
        add(label);

        JButton startButton = new JButton("Начать");
        JButton optionsButton = new JButton("Настройки");
        JButton exitButton = new JButton("Выход");

        startButton.setBounds(400, 300, 200, 50);
        startButton.addActionListener(e ->
                menu.getCardLayout().show(menu.getContentPane(), "modeMenu"));

        optionsButton.setBounds(400, 400, 200, 50);

        exitButton.setBounds(400, 500, 200, 50);
        exitButton.addActionListener(e -> System.exit(0));

        add(startButton);
        add(optionsButton);
        add(exitButton);

    }
}
