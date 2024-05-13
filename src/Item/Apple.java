package Item;

import Snake.Snake;

import javax.swing.*;
import java.awt.*;

public class Apple extends AbstractItem {
    Image appleImage;
    public Apple() {
        setImage();
        create();
    }

    @Override
    public Image getImage() {
        return appleImage;
    }

    @Override
    public void setImage() {
        appleImage = new ImageIcon("resources/Images/apple.png").getImage();
    }

    @Override
    public void interaction(Snake snake) {
       int size = snake.getSizeSnake();
       snake.setSizeSnake(size+1);
    }
}
