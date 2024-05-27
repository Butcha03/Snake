package menu;

import javax.swing.*;
import java.awt.*;

public class OptionMenu extends Panel {
    private Menu menu;
    public OptionMenu(Menu menu) {
        this.menu = menu;
        setLayout(null);
        setBackground(new Color(139, 69, 19));
        createOptionLabel();
        BackButton();
    }

    private void BackButton() {
        JButton backButton = new JButton("Назад");
        backButton.setBounds(750, 700, 200, 50);
        backButton.addActionListener(e -> menu.getCardLayout().show(menu.getContentPane(), "startMenu"));
        add(backButton);
    }

    private void createOptionLabel() {
        Label optionsLabel = new Label("Настройки");
        optionsLabel.setFont(new Font("Arial", Font.BOLD, 34));
        optionsLabel.setBounds(100, 50, 200, 50);
        add(optionsLabel);
    }
}
