import javax.swing.*;
import java.awt.*;

public class Snake {
    private Image bodyImage;
    private Image[] headImages;

    public Snake(Image bodyImage, Image[] headImages) {
        this.bodyImage = bodyImage;
        this.headImages = headImages;
    }

    public Image getBodyImage() {
        return bodyImage;
    }

    public Image getHeadRightImages() {
        return headImages[0];
    }

    public Image getHeadDownImages() {
        return headImages[1];
    }
    public Image getHeadLeftImages() {
        return headImages[2];
    }
    public Image getHeadUpImages() {
        return headImages[3];
    }
}
