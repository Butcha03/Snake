package GameLogic;

import Snake.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Item.*;
import Player.*;

public class GameFieldTest extends JPanel implements ActionListener {
    public static final int SIZE = 600;
    public static final int DOT_SIZE = 20;
    public static final int ALL_DOTS = 900;
    private Timer gameTimer;
    private Image backgroundImage;
    private Snake snake;
    private Snake snake2;

    private ArrayList<AbstractItem> listItem = new ArrayList<>();

    public GameFieldTest(){

        Player player = new Player();
        Player player2 = new Player();

        this.snake = player.getSnake();
        initSnake(this.snake,0, 0);

        this.snake2 = player2.getSnake();
        initSnake(this.snake2, 10, 10);

        this.backgroundImage = new ImageIcon("resources/Images/back.png").getImage();
        addKeyListener(new FieldKeyListener());
        addKeyListener(new FieldKeyListener2());
        setFocusable(true);

        createItem(new Apple());

        this.gameTimer = new Timer(100, this);
        this.gameTimer.start();
        GameState.startGame();

    }

    private void initSnake(Snake snake, int x, int y) {
        for (int i = 0; i < snake.getSizeSnake(); i++) {
            snake.x[i] = (60+x*20) - i*DOT_SIZE;
            snake.y[i] = (60+y*20);
        }
    }

    private void createItem(AbstractItem item)
    {
        listItem.add(item);
    }

    private void checkItem(Snake snake)
    {
        for (int i = 0; i < listItem.size(); i++)
        {
            if(snake.getHeadX() == listItem.get(i).getX() &&
                    snake.getHeadY() == listItem.get(i).getY())
            {
                AbstractItem item = listItem.get(i);
                item.interaction(snake);
                item.create();
                listItem.remove(i);
                listItem.add(item);
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
        if(GameState.inGame){
            for(int i = 0; i < listItem.size(); i++){
                g.drawImage(listItem.get(i).getImage(), listItem.get(i).getX(), listItem.get(i).getY(), this);
            }
            for(int i = 1; i < snake.getSizeSnake(); i++){
                g.drawImage(snake.getHeadImage(), snake.x[0], snake.y[0], this);
                g.drawImage(snake.getBodyImage(), snake.x[i], snake.y[i], this);

            }
            for (int i = 1; i < snake2.getSizeSnake(); i++)
            {
                g.drawImage(snake2.getHeadImage(), snake2.x[0], snake2.y[0], this);
                g.drawImage(snake2.getBodyImage(), snake2.x[i], snake2.y[i], this);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(GameState.inGame){
            snake.checkCollisions();
            snake.move();
            //snake2.checkCollisions();
            snake2.move();

            checkItem(snake);
            checkItem(snake2);
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !snake.right){
                snake.left = true;
                snake.up = false;
                snake.down = false;
                snake.turnHeadLeft();
            }
            if(key == KeyEvent.VK_RIGHT && !snake.left){
                snake.right = true;
                snake.up = false;
                snake.down = false;
                snake.turnHeadRight();

            }

            if(key == KeyEvent.VK_UP && !snake.down){
                snake.right = false;
                snake.up = true;
                snake.left = false;
                snake.turnHeadUp();

            }
            if(key == KeyEvent.VK_DOWN && !snake.up){
                snake.right = false;
                snake.down = true;
                snake.left = false;
                snake.turnHeadDown();
            }
            //if(key == KeyEvent.VK_5 && timer.isRunning()){
            //    timer.stop();
            //}else {
            //    timer.start();
            //}

        }
    }

    class FieldKeyListener2 extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_A && !snake2.right){
                snake2.left = true;
                snake2.up = false;
                snake2.down = false;
                snake2.turnHeadLeft();
            }
            if(key == KeyEvent.VK_D && !snake2.left){
                snake2.right = true;
                snake2.up = false;
                snake2.down = false;
                snake2.turnHeadRight();

            }

            if(key == KeyEvent.VK_W && !snake2.down){
                snake2.right = false;
                snake2.up = true;
                snake2.left = false;
                snake2.turnHeadUp();

            }
            if(key == KeyEvent.VK_S && !snake2.up){
                snake2.right = false;
                snake2.down = true;
                snake2.left = false;
                snake2.turnHeadDown();
            }
            //if(key == KeyEvent.VK_5 && timer.isRunning()){
            //    timer.stop();
            //}else {
            //    timer.start();
            //}

        }
    }
}
