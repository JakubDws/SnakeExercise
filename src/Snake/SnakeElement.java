package Snake;

public class SnakeElement {

    int positionX;
    int positionY;
    final static int ELEMENT_SIZE = 10;
    Direction direction;

    public  SnakeElement(int positionX, int positionY, Direction direction){
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }
}
