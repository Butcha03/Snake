import javax.swing.*;
import java.awt.*;

public class Snake {
    private Image bodyImage;
    private Image[] headImages;

    public Snake() {
        loadImages();
    }
    private void loadImages(){
        this.bodyImage = new ImageIcon("resources/Images/dot.png").getImage();
        this.headImages = new Image[4];
        headImages[0] = new ImageIcon("resources/Images/Snake/HeadRight.png").getImage();
        headImages[1] = new ImageIcon("resources/Images/Snake/HeadDown.png").getImage();
        headImages[2] = new ImageIcon("resources/Images/Snake/HeadLeft.png").getImage();
        headImages[3] = new ImageIcon("resources/Images/Snake/HeadUp.png").getImage();
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
