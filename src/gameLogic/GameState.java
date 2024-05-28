package gameLogic;

import GameUI.Field;
import snake.Snake;

import javax.swing.*;
import java.awt.*;

public class GameState {
    public static boolean inGame;
    public static Timer gameTimer;
    public static void startGame() {
        inGame = true;
    }
    public static void victory(Snake snake, Field gameField)
    {

        JLabel victoryLabel = new JLabel(snake.getName() + " Победил");
        victoryLabel.setBackground(Color.gray);
        victoryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        victoryLabel.setBounds(200, 200, 200, 200);
        gameField.add(victoryLabel);
        inGame = false;
    }
    public static void lose(Snake snake, Field gameField)
    {
        JLabel loseLabel = new JLabel(snake.getName() + " Проиграл");
        loseLabel.setBackground(Color.gray);
        loseLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loseLabel.setBounds(200, 200, 200, 200);
        gameField.add(loseLabel);
        inGame = false;
    }
}
