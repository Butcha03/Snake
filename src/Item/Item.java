package Item;

import java.awt.*;

public interface Item {
    static void loadImage(Image image){};
    Image getImage();
    void setX(int x);
    void setY(int y);
    int getX();
    int getY();


}
