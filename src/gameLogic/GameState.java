package gameLogic;

import snake.Snake;

import javax.swing.*;
import java.awt.*;

public class GameState {
    public static boolean inGame;
    public static Timer gameTimer;
    public static void startGame() {
        inGame = true;
    }
    public static void victory(Snake snake, GameField gameField)
    {

        JLabel victoryLabel = new JLabel(snake.getName() + " Победил");
        victoryLabel.setBackground(Color.gray);
        victoryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        victoryLabel.setBounds(200, 200, 200, 200);
        gameField.add(victoryLabel);

        inGame = false;
    }


}
