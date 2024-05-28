package gameLogic;

import GameUI.Field;
import GameUI.Window;
import item.Apple;
import player.Player;
import snake.Snake;

public class GameLogicClassic {
    public GameLogicClassic(Player player)
    {
        Snake snake = player.getSnake();
        Window window = new Window();
        Field gameField = window.getGameField();
        gameField.initSnake(snake,0, 0);
        gameField.createItem(new Apple());
    }
}
