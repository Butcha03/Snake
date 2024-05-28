
import menu.Menu;
import player.Player;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Lev");
        Player player2 = new Player("Ivan");
        new Menu(player1, player2);


    }
}
