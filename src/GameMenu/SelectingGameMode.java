package GameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GameLogic.*;
public class SelectingGameMode extends JFrame {

    public SelectingGameMode(){
        setTitle("Меню");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,620);
        getContentPane().setBackground(new Color(139, 69, 19));

        // Get the screen size to center the window
        CenterAlignment();
        add(getTitleLabel());
        add(createStartGameButton());
        add(createSettingsButton());
        add(createExitButton());

        setLayout(null); // Используем абсолютное позиционирование
        setVisible(true);
    }

    private static JLabel getTitleLabel() {
        JLabel titleLabel = new JLabel("Меню");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 34));
        titleLabel.setBounds(250, 50, 100, 30);
        return titleLabel;
    }

    private void CenterAlignment() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    private JButton createExitButton() {
        JButton exitButton = new JButton("Назад");
        exitButton.setBounds(200, 300, 200, 30);
        exitButton.setBackground(new Color(139, 0, 0)); // Темно-красный цвет
        exitButton.setForeground(Color.WHITE); // Белый текст
        actionExitButton(exitButton);
        return exitButton;
    }

    private void actionExitButton(JButton exitButton) {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new MenuWindow();
            }
        });
    }

    private JButton createSettingsButton() {
        JButton settingsButton = new JButton("Игра в двоем");
        settingsButton.setBounds(200, 250, 200, 30);
        settingsButton.setBackground(new Color(0, 128, 0)); // Зеленый цвет
        settingsButton.setForeground(Color.WHITE); // Белый текст
        actionSettingButton(settingsButton);
        return settingsButton;
    }

    private void actionSettingButton(JButton settingsButton) {
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                GameWindow gameWindow = new GameWindow();
            }
        });
    }

    private JButton createStartGameButton() {
        JButton startGameButton = new JButton("Одиночная игра");
        startGameButton.setBounds(200, 200, 200, 30);
        startGameButton.setBackground(new Color(0, 128, 0));
        startGameButton.setForeground(Color.WHITE);
        actionStartGameButton(startGameButton);
        return startGameButton;
    }

    private void actionStartGameButton(JButton startGameButton) {
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                GameWindow gameWindow = new GameWindow();
            }
        });
    }
}
