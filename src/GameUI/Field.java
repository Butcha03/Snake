package GameUI;
import gameLogic.GameState;
import item.Apple;
import snake.Snake;
import item.AbstractItem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Field extends JPanel {
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = 900;
    private ArrayList<Snake> snakes = new ArrayList<>();
    private ArrayList<AbstractItem> listItem = new ArrayList<>();

    public Field() {
        setBounds(200, 100, 600, 600);
    }

    public void addSnake(Snake snake, int x, int y) {
        initSnake(snake, x, y);
    }

    private void initSnake(Snake snake, int x, int y) {
        for (int i = 0; i < snake.getSizeSnake(); i++) {
            snake.setX((60+x*20) - i*DOT_SIZE, i);
            snake.setY(60+y*20, i);
            snakes.add(snake);
        }
    }

    public void addItem(AbstractItem item) {
        listItem.add(item);
    }
    public void draw()
    {
        paintComponent(this.getGraphics());
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(new ImageIcon("resources/Images/back.png").getImage(), 0, 0, this);
        for (Snake snake : snakes) {
            for (int i = 1; i < snake.getSizeSnake(); i++) {
                g.drawImage(snake.getHeadImage(), snake.getX(0), snake.getY(0), this);
                g.drawImage(snake.getBodyImage(), snake.getX(i), snake.getY(i), this);
            }
        }
    }
}
