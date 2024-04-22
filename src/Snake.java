import javax.swing.*;
import java.awt.*;

public class Snake {
    private Image bodyImage;
    private Image headImage;
    private Image[] headImages;

    public Snake(Image bodyImage, Image[] headImages) {
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
}
