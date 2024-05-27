package item;
import snake.*;
import java.awt.*;

public interface Item {

    Image getImage();
    void setImage();
    void setX(int x);
    void setY(int y);
    int getX();
    int getY();

    void interaction(Snake snake);

}
