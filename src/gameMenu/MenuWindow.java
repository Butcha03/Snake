package gameMenu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {

    private final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public MenuWindow(){
        setTitle("Меню");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
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

    private static JButton createExitButton() {
        JButton exitButton = new JButton("Выход");
        exitButton.setBounds(200, 300, 200, 30);
        exitButton.setBackground(new Color(139, 0, 0)); // Темно-красный цвет
        exitButton.setForeground(Color.WHITE); // Белый текст
        actionExitButton(exitButton);
        return exitButton;
    }

    private static void actionExitButton(JButton exitButton) {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private static JButton createSettingsButton() {
        JButton settingsButton = new JButton("Настройки");
        settingsButton.setBounds(200, 250, 200, 30);
        settingsButton.setBackground(new Color(0, 128, 0)); // Зеленый цвет
        settingsButton.setForeground(Color.WHITE); // Белый текст
        actionSettingButton(settingsButton);
        return settingsButton;
    }

    private static void actionSettingButton(JButton settingsButton) {
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Открыть настройки");
            }
        });
    }

    private JButton createStartGameButton() {
        JButton startGameButton = new JButton("Играть");
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
                new SelectingGameMode ();
                //GameWindow gameWindow = new GameWindow();
            }
        });
    }
}