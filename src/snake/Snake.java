package snake;
import gameLogic.*;
import java.awt.*;

public class Snake {
    private final int SIZE = 600;
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = 900;
    private Image bodyImage;
    private Image headImage;
    private Image[] headImages;
    private int speed;
    private int sizeSnake;
    private int[] x = new int[SIZE];
    private int[] y = new int[SIZE];
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    public Snake(Image bodyImage, Image[] headImages)
    {
        loadImage(bodyImage, headImages);
        this.sizeSnake = 3;

    }
    public Snake(Image bodyImage, Image[] headImages,
                 int speed, int size) {

        loadImage(bodyImage, headImages);
        this.speed = speed;
    }

    private void loadImage(Image bodyImage, Image[] headImages) {
        this.bodyImage = bodyImage;
        this.headImages = headImages;
        this.headImage = headImages[0];
    }

    public void setLeftMove(boolean leftMove){
        left = leftMove;
    }

    public boolean getLeftMove(){
        return left;
    }

    public void setRightMove(boolean rightMove){
        right = rightMove;
    }

    public boolean getRightMove(){
        return right;
    }

    public void setUpMove(boolean upMove){
        up = upMove;
    }

    public boolean getUpMove(){
        return up;
    }

    public void setDownMove(boolean downMove){
        down = downMove;
    }

    public boolean getDownMove(){
        return down;
    }

    public Image getBodyImage() {
        return bodyImage;
    }

    public Image getHeadImage(){
        return headImage;
    }

    public int getHeadX()
    {
        return x[0];
    }
    public int getHeadY()
    {
        return y[0];
    }

    public void turnHeadRight() {
         headImage = headImages[0];
    }

    public void turnHeadDown() {
        headImage = headImages[1];
    }
    public void turnHeadLeft() {
        headImage = headImages[2];
    }
    public void turnHeadUp() {
        headImage = headImages[3];
    }

    public int getSpeed() {
        return speed;
    }

    public void getSpeed(int speed) {
        this.speed = speed;
    }

    public int getSizeSnake() {
        return sizeSnake;
    }

    public void setSizeSnake(int sizeSnake) {
        this.sizeSnake = sizeSnake;
    }

    public int getX(int i) {
        return x[i];
    }
    public int getY(int i) {
        return y[i];
    }
    public void setX(int x, int i) {
        this.x[i] = x;
    }
    public void setY(int y, int i) {
        this.y[i] = y;
    }

    public void checkCollisions(){
        for (int i = getSizeSnake(); i > 0 ; i--) {
            if(i>4 && x[0] == x[i] && y[0] == y[i]){
                GameState.inGame = false;
            }
        }
        if(x[0]>=SIZE){
            GameState.inGame = false;
        }
        if(x[0]<0){
            GameState.inGame = false;
        }
        if(y[0]>=SIZE){
            GameState.inGame = false;
        }
        if(y[0]<0){
            GameState.inGame = false;
        }
    }

    public void checkEnemySnake(Snake enemySnake) {

        for(int i = enemySnake.getSizeSnake(); i >  0; i--)
        {
            if(x[0] == enemySnake.x[i] && y[0] == enemySnake.y[i])
            {
                GameState.inGame = false;
            }
        }
    }

    public void move(){

        for (int i = getSizeSnake(); i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if(left){
            x[0] -= DOT_SIZE;
        }
        if(right){
            x[0] += DOT_SIZE;
        } if(up){
            y[0] -= DOT_SIZE;
        } if(down){
            y[0] += DOT_SIZE;
        }

    }

}