import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame {

    public MainWindow(){
        InitFrame();
        //tInitGame.InitGameSolo();
    }

    private void CenterAlignment() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    private void InitFrame()
    {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,800);
        CenterAlignment();
        add(new GameFieldTest());
        setVisible(true);
    }
}