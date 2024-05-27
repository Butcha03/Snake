package item;

import snake.Snake;

import javax.swing.*;
import java.awt.*;

public class GoldApple extends AbstractItem{
    private Image appleGoldImage;

    public GoldApple() {
        setImage();
        create();
    }

    @Override
    public Image getImage() {
        return appleGoldImage;
    }

    @Override
    public void setImage() {
        appleGoldImage = new ImageIcon("resources/Images/apple gold.png").getImage();
    }

    @Override
    public void interaction(Snake snake) {
        int size = snake.getSizeSnake();
        snake.setSizeSnake(size+2);
    }
}
