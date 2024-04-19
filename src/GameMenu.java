import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {
    private static boolean gameMenuOpen;
    public GameMenu(){
        gameMenuOpen = true;
        setTitle("Меню");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,620);
        getContentPane().setBackground(new Color(139, 69, 19));

        // Get the screen size to center the window
        CenterAlignment();

        JLabel titleLabel = getTitleLabel();
        add(titleLabel);

        JButton startGameButton = getStartGameButton();
        JButton settingsButton = getSettingsButton();
        JButton exitButton = getExitButton();
        add(startGameButton);
        add(settingsButton);
        add(exitButton);

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

    private static JButton getExitButton() {
        JButton exitButton = new JButton("Выход");
        exitButton.setBounds(250, 300, 100, 30);
        exitButton.setBackground(new Color(139, 0, 0)); // Темно-красный цвет
        exitButton.setForeground(Color.WHITE); // Белый текст
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return exitButton;
    }

    private static JButton getSettingsButton() {
        JButton settingsButton = new JButton("Настройки");
        settingsButton.setBounds(250, 250, 100, 30);
        settingsButton.setBackground(new Color(0, 128, 0)); // Зеленый цвет
        settingsButton.setForeground(Color.WHITE); // Белый текст
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Открыть настройки");
            }
        });
        return settingsButton;
    }

    private JButton getStartGameButton() {
        JButton startGameButton = new JButton("Играть");
        startGameButton.setBounds(250, 200, 100, 30);
        startGameButton.setBackground(new Color(0, 128, 0));
        startGameButton.setForeground(Color.WHITE);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMenuOpen = false;
                setVisible(gameMenuOpen);
                MainWindow mainWindow = new MainWindow();
            }
        });
        return startGameButton;
    }
}