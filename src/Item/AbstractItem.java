package Item;
import Snake.Snake;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class AbstractItem implements Item{

    private final int DOT_SIZE = 20;
    private Image appleImage;
    private int itemX;
    private int itemY;

    public AbstractItem(){
        setImage();
        create();
    }
    public void create(){
        itemX = new Random().nextInt(20)*DOT_SIZE;
        itemY = new Random().nextInt(20)*DOT_SIZE;
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
    public void setX(int x) {
        itemX = x;
    }

    @Override
    public void setY(int y) {
        itemY = y;
    }

    @Override
    public int getX() {
        return itemX;
    }

    @Override
    public int getY() {
        return itemY;
    }
    public abstract void interaction(Snake snake);

}
