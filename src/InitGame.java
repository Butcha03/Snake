import Item.Apple;

import javax.swing.*;

public class InitGame {
    public static void InitGameSolo(){
        Apple.setImage(new ImageIcon("resources/Images/apple.png").getImage());
        GameFieldTest gameFieldTest = new GameFieldTest();
        gameFieldTest.loadImageFieldBeck(new ImageIcon("resources/Images/back.png").getImage());
        gameFieldTest.placeItemField(new Apple());

    }

    public static void InitGameMulti(){
        Apple.setImage(new ImageIcon("resources/Images/apple.png").getImage());
        GameFieldTest gameFieldTest = new GameFieldTest();
        gameFieldTest.loadImageFieldBeck(new ImageIcon("resources/Images/back.png").getImage());

    }

}
