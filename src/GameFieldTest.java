import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import Item.*;

public class GameFieldTest extends JPanel {
    private static final int DOT_SIZE = 20;
    private static final int ROWS = 30;
    private static final int COLUMNS = 40;
    private Image imageFieldBeck;

    private static ArrayList<Item> items = new ArrayList<Item>();
    public GameFieldTest() {

    }

    public void loadImageFieldBeck(Image image) {
        this.imageFieldBeck = image;
    }

    public void placeItemField(Item item) {
        item.setX(new Random().nextInt(20)*DOT_SIZE);
        item.setY(new Random().nextInt(20)*DOT_SIZE);
        items.add(item);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                int x = col * DOT_SIZE;
                int y = row * DOT_SIZE;
                g.drawRect(x, y, DOT_SIZE, DOT_SIZE);
            }
        }
        g.drawImage(imageFieldBeck, 0, 0, this);
        for (Item item : items) {
            g.drawImage(item.getImage(), item.getX(), item.getY(), this);
        }
    }

    public static void main(String[] args) {

    }
}

