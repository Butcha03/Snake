import java.awt.*;
import java.util.Random;

public class Apples extends GameField {
    private final int DOT_SIZE = 20;
    private Image dot;
    private int appleX;
    private int appleY;
    public void createApple(){
        appleX = new Random().nextInt(20)*DOT_SIZE;
        appleY = new Random().nextInt(20)*DOT_SIZE;
    }

}
