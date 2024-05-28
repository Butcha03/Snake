package gameLogic;

import GameUI.Field;
import GameUI.Window;
import item.Apple;
import item.GoldApple;
import player.Player;
import snake.Snake;

public class GameLogicMulti {

    public GameLogicMulti(Player player1, Player player2) {
        Snake snake1 = player1.getSnake();
        Snake snake2 = player2.getSnake();
        Window window = new Window();
        Field gameField = window.getGameField();
        gameField.initSnake(snake1,0, 0);
        gameField.initSnake(snake2, 0, 10);
        gameField.createItem(new Apple());
        gameField.createItem(new GoldApple());

    }
}
