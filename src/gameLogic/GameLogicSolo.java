package gameLogic;

import GameUI.Window;
import item.Apple;
import item.GoldApple;
import player.Player;
import snake.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLogicSolo {
    public GameLogicSolo(Player player) {
        Snake snake = player.getSnake();
        GameWindow window = new GameWindow();
        GameField gameField = window.getGameField();
        gameField.initSnake(snake,0, 0);
        gameField.createItem(new Apple());
        gameField.createItem(new GoldApple());

    }


}