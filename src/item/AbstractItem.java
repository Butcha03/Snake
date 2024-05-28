package item;
import snake.Snake;

import java.awt.*;
import java.util.Random;

public abstract class AbstractItem implements Item{

    private final int DOT_SIZE = 20;
    private Image appleImage;
    private int itemX;
    private int itemY;

    public AbstractItem(){
        setImage();
        create();
    }

    public void create(){
        // Вычисляем количество клеток по горизонтали и вертикали
        int cellsX = (760 - 40) / DOT_SIZE;
        int cellsY = (760 - 40) / DOT_SIZE;

        // Генерируем случайные индексы клеток
        int randomCellX = new Random().nextInt(cellsX);
        int randomCellY = new Random().nextInt(cellsY);

        // Вычисляем координаты центра клетки
        itemX = 40 + randomCellX * DOT_SIZE;
        itemY = 40 + randomCellY * DOT_SIZE;
    }


    @Override
    abstract public Image getImage();

    @Override
    abstract public void setImage();
    @Override
    public void setX(int x) {
        itemX = x;
    }

    @Override
    public void setY(int y) {
        itemY = y;
    }

    @Override
    public int getX() {
        return itemX;
    }

    @Override
    public int getY() {
        return itemY;
    }
    public abstract void interaction(Snake snake);

}
