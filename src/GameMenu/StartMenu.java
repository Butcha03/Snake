package GameMenu;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JPanel{

    private final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    Button startButton = new Button();
    public StartMenu(){
        setPreferredSize(new Dimension(WINDOW_WIDTH/2,WINDOW_HEIGHT/2));
        setVisible(true);
        setLayout(null);
    }

}
