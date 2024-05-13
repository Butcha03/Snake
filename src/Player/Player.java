package Player;

import Snake.Snake;

import javax.swing.*;
import java.awt.*;

public class Player {
    private Snake snake;
    public Player(){
        this.snake = new Snake(loadBodySnake(), loadHeadSnake());
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


