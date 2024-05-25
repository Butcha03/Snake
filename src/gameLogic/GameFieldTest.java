package gameLogic;

import snake.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import item.*;
import player.*;

public class GameFieldTest extends JPanel implements ActionListener {
    private final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
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
        initSnake(this.snake2, 0, 10);

        this.backgroundImage = new ImageIcon("resources/Images/back.png").getImage();
        addKeyListener(new FieldKeyListener());
        FieldKeyListener2 fieldKeyListener2 = new FieldKeyListener2();
        addKeyListener(new FieldKeyListener2());
        setFocusable(true);

        createItem(new Apple());
        createItem(new GoldApple());

        this.gameTimer = new Timer(130, this);
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
        g.drawImage(backgroundImage,0, 0 , this);
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
            snake.checkEnemySnake(snake2);
            snake.move();
            snake2.checkCollisions();
            snake2.checkEnemySnake(snake);
            snake2.move();

            checkItem(snake);
            checkItem(snake2);
        }
        repaint();

    }

    class FieldKeyListener extends KeyAdapter {
        private int leftKey = KeyEvent.VK_LEFT;
        private int rightKey = KeyEvent.VK_RIGHT;
        private int upKey = KeyEvent.VK_UP;
        private int downKey = KeyEvent.VK_DOWN;

        public void updateControlKeys(int newLeftKey, int newRightKey, int newUpKey, int newDownKey) {
            leftKey = newLeftKey;
            rightKey = newRightKey;
            upKey = newUpKey;
            downKey = newDownKey;
        }
        @Override
        public void keyPressed(KeyEvent e) {

            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == leftKey && !snake.getRightMove()){
                snake.setLeftMove(true);
                snake.setUpMove(false);
                snake.setDownMove(false);
                snake.turnHeadLeft();
            }
            if(key == rightKey && !snake.getLeftMove()){
                snake.setRightMove(true);
                snake.setUpMove(false);
                snake.setDownMove(false);
                snake.turnHeadRight();
            }

            if(key == upKey && !snake.getDownMove()){
                snake.turnHeadUp();
                snake.setRightMove(false);
                snake.setUpMove(true);
                snake.setLeftMove(false);

            }
            if(key == downKey && !snake.getUpMove()){
                snake.turnHeadDown();
                snake.setRightMove(false);
                snake.setDownMove(true);
                snake.setLeftMove(false);
            }
            if(key == KeyEvent.VK_P && gameTimer.isRunning()){
                gameTimer.stop();
            }else {
                gameTimer.start();
            }

        }

    }

    class FieldKeyListener2 extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_A && !snake2.getRightMove()) {
                snake2.setLeftMove(true);
                snake2.setUpMove(false);
                snake2.setDownMove(false);
                snake2.turnHeadLeft();
            }
            if (key == KeyEvent.VK_D && !snake2.getLeftMove()) {
                snake2.setRightMove(true);
                snake2.setUpMove(false);
                snake2.setDownMove(false);
                snake2.turnHeadRight();
            }

            if (key == KeyEvent.VK_W && !snake2.getDownMove()) {
                snake2.turnHeadUp();
                snake2.setRightMove(false);
                snake2.setUpMove(true);
                snake2.setLeftMove(false);

            }
            if (key == KeyEvent.VK_S && !snake2.getUpMove()) {
                snake2.turnHeadDown();
                snake2.setRightMove(false);
                snake2.setDownMove(true);
                snake2.setLeftMove(false);
            }
        }
    }
}
