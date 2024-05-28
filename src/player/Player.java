package player;

import snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class Player {
    private Snake snake;
    private String name;
    public Player(String name){
        this.name = name;
        this.snake = new Snake(loadBodySnake(), loadHeadSnake(), name);
    }

    private Image loadBodySnake() {
        return new ImageIcon("resources/Images/Snake/dot.png").getImage();
    }
    private Image[] loadHeadSnake() {
        return new Image[]{
                new ImageIcon("resources/Images/Snake/HeadRight.png").getImage(),
                new ImageIcon("resources/Images/Snake/HeadDown.png").getImage(),
                new ImageIcon("resources/Images/Snake/HeadLeft.png").getImage(),
                new ImageIcon("resources/Images/Snake/HeadUp.png").getImage()};
    }

    public Snake getSnake()
    {
        return this.snake;
    }

}


