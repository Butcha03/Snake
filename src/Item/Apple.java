package Item;

import java.awt.*;

public class Apple implements Item{

    private int x;
    private int y;
    private final int DOT_SIZE = 20;
    private static Image image;
    public Apple(){}
    public static void setImage(Image image){
        Apple.image = image;
    }
    public Image getImage(){
        return image;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}



