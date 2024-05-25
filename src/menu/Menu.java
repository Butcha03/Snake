package menu;

import gameLogic.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JPanel startMenu, modeMenu;
    CardLayout cardLayout;

    public Menu() {
        setTitle("Змеийка");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(300,0);
        // Создание панелей
        startMenu = new JPanel();
        startMenu.setLayout(null);
        startMenu.setBackground(new Color(139, 69, 19));
        JButton startButton = new JButton("Играть");
        startButton.setBounds(400, 300, 200, 50);
        startButton.addActionListener(e -> cardLayout.show(getContentPane(), "modeMenu"));
        JButton optionsButton = new JButton("Настройки");
        optionsButton.setBounds(400, 400, 200, 50);
        JButton exitButton = new JButton("Выход");
        exitButton.setBounds(400, 500, 200, 50);
        exitButton.addActionListener(e -> System.exit(0));
        startMenu.add(startButton);
        startMenu.add(optionsButton);
        startMenu.add(exitButton);

        modeMenu = new JPanel();
        modeMenu.setLayout(null);
        modeMenu.setBackground(new Color(139, 69, 19));
        JButton soloGameButton = new JButton("Одиночная игра");
        soloGameButton.setBounds(400, 300, 200, 50);
        soloGameButton.addActionListener(e -> new GameWindow());
        JButton multiplayerGameButton = new JButton("Мультиплейер");
        multiplayerGameButton.setBounds(400, 400, 200, 50);
        multiplayerGameButton.addActionListener(e -> new GameWindow());
        JButton backButton = new JButton("Назад");
        backButton.setBounds(400, 500, 200, 50);
        backButton.addActionListener(e -> cardLayout.show(getContentPane(), "startMenu"));
        modeMenu.add(soloGameButton);
        modeMenu.add(multiplayerGameButton);
        modeMenu.add(backButton);

        // Настройка CardLayout
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Добавление панелей в CardLayout
        add(startMenu, "startMenu");
        add(modeMenu, "modeMenu");

        // Установка начальной видимой панели
        cardLayout.show(getContentPane(), "startMenu");
        setSize(1000, 800);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Переключить на панель 2")) {
            cardLayout.show(getContentPane(), "panel2");
        } else if (e.getActionCommand().equals("Переключить на панель 1")) {
            cardLayout.show(getContentPane(), "panel1");
        }
    }

    private void CenterAlignment() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu());
    }
}
