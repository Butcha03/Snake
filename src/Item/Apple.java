package Item;

import Snake.Snake;

public class Apple extends AbstractItem {

    public Apple() {}
    @Override
    public void interaction(Snake snake) {
       int size = snake.getSizeSnake();
       snake.setSizeSnake(size+1);
    }
}
