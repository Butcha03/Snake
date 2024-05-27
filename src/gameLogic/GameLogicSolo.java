package gameLogic;

import GameUI.Field;
import GameUI.Window;
import player.Player;
import snake.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogicSolo {
    private Snake snake;
    public GameLogicSolo(Player player) {
        this.snake = player.getSnake();
        GameWindow window = new GameWindow();

    }


}