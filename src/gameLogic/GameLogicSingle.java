package gameLogic;

import GameUI.Field;
import GameUI.Window;
import item.Apple;
import item.GoldApple;
import player.Player;
import snake.Snake;

public class GameLogicSingle {
    public GameLogicSingle(Player player) {
        Snake snake = player.getSnake();
        Window window = new Window();
        Field gameField = window.getGameField();
        gameField.initSnake(snake,0, 0);
        gameField.createItem(new Apple());
        gameField.createItem(new GoldApple());

    }


}