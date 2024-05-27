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

public class GameField extends JPanel implements ActionListener {

    private static final int FILED_SIZE = 600;
    private static final int FILED_X = 200;
    private static final int FILED_Y = 100;
    private static final int DOT_SIZE = 20;
    private static final int ALL_DOTS = 900;
    private Timer gameTimer;
    private Image backgroundImage;
    private ArrayList<AbstractItem> listItem = new ArrayList<>();
    private ArrayList<Snake> snakes = new ArrayList<>();

    public GameField(){

        setBounds(FILED_X, FILED_Y, FILED_SIZE, FILED_SIZE);


        this.backgroundImage = new ImageIcon("resources/Images/back.png").getImage();

        addKeyListener(new FieldKeyListener());
        addKeyListener(new FieldKeyListener2());

        this.gameTimer = new Timer(130, this);
        this.gameTimer.start();
        setFocusable(true);
        GameState.startGame();

    }

    public void initSnake(Snake snake, int x, int y) {
        for (int i = 0; i < snake.getSizeSnake(); i++) {
            snake.setX((60+x*20) - i*DOT_SIZE, i);
            snake.setY(60+y*20, i);
        }
        snakes.add(snake);
    }

    public void createItem(AbstractItem item)
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
            for (AbstractItem abstractItem : listItem) {
                g.drawImage(abstractItem.getImage(), abstractItem.getX(), abstractItem.getY(), this);
            }
            for (Snake snake : snakes) {
                for (int j = 1; j < snake.getSizeSnake(); j++) {
                    g.drawImage(snake.getHeadImage(), snake.getX(0), snake.getY(0), this);
                    g.drawImage(snake.getBodyImage(), snake.getX(j), snake.getY(j), this);
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(GameState.inGame){
           for (Snake snake : snakes){
               snake.move(snake);
               checkItem(snake);
           }
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
            if(key == leftKey && !snakes.get(0).getRightMove()){
                snakes.get(0).setLeftMove(true);
                snakes.get(0).setUpMove(false);
                snakes.get(0).setDownMove(false);
                snakes.get(0).turnHeadLeft();
            }
            if(key == rightKey && !snakes.get(0).getLeftMove()){
                snakes.get(0).setRightMove(true);
                snakes.get(0).setUpMove(false);
                snakes.get(0).setDownMove(false);
                snakes.get(0).turnHeadRight();
            }

            if(key == upKey && !snakes.get(0).getDownMove()){
                snakes.get(0).turnHeadUp();
                snakes.get(0).setRightMove(false);
                snakes.get(0).setUpMove(true);
                snakes.get(0).setLeftMove(false);

            }
            if(key == downKey && !snakes.get(0).getUpMove()){
                snakes.get(0).turnHeadDown();
                snakes.get(0).setRightMove(false);
                snakes.get(0).setDownMove(true);
                snakes.get(0).setLeftMove(false);
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
            if (key == KeyEvent.VK_A && !snakes.get(1).getRightMove()) {
                snakes.get(1).setLeftMove(true);
                snakes.get(1).setUpMove(false);
                snakes.get(1).setDownMove(false);
                snakes.get(1).turnHeadLeft();
            }
            if (key == KeyEvent.VK_D && !snakes.get(1).getLeftMove()) {
                snakes.get(1).setRightMove(true);
                snakes.get(1).setUpMove(false);
                snakes.get(1).setDownMove(false);
                snakes.get(1).turnHeadRight();
            }

            if (key == KeyEvent.VK_W && !snakes.get(1).getDownMove()) {
                snakes.get(1).turnHeadUp();
                snakes.get(1).setRightMove(false);
                snakes.get(1).setUpMove(true);
                snakes.get(1).setLeftMove(false);

            }
            if (key == KeyEvent.VK_S && !snakes.get(1).getUpMove()) {
                snakes.get(1).turnHeadDown();
                snakes.get(1).setRightMove(false);
                snakes.get(1).setDownMove(true);
                snakes.get(1).setLeftMove(false);
            }
        }
    }
}
