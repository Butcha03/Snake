import javax.swing.*;


public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,620);
        setLocation(750,250);
        add(new GameField());

        setVisible(true);
    }
}