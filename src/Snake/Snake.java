package Snake;
import GameLogic.*;
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
    public int[] x = new int[SIZE];
    public int[] y = new int[SIZE];
    public boolean left = false;
    public boolean right = true;
    public boolean up = false;
    public boolean down = false;

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