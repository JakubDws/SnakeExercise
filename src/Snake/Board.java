package Snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Board extends JPanel {

    static List<SnakeElement> snakeElements = new LinkedList<>();
    Timer timer = new Timer(200, e -> move());
    SnakeElement snakeHead = new SnakeElement(200, 200, Direction.RIGHT);
    Move move = new Move();
    ChunkGenerator chunk = new ChunkGenerator();

    public Board(){
        this.setBackground(Color.GRAY);
        chunk.generateChunkPosition(snakeElements);
        snakeElements.add(snakeHead);
        addNextBlock();
        addNextBlock();
        addNextBlock();
        addNextBlock();
        addNextBlock();
        addNextBlock();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        for (int i = 0; i <snakeElements.size() ; i++) {
            g.fillRect(snakeElements.get(i).positionX,snakeElements.get(i).positionY,SnakeElement.ELEMENT_SIZE,SnakeElement.ELEMENT_SIZE);
        }
        g.setColor(Color.MAGENTA);
        g.fillRect(chunk.chunkPosX, chunk.chunkPosY, SnakeElement.ELEMENT_SIZE, SnakeElement.ELEMENT_SIZE);
    }

    private void move() {
        move.moveBodyBlock();
        move.moveHeadBlock();
        move.isHeadOutOfBounds();
        move.snakeEatChunk(chunk);
        move.snakeEatSnake();
        repaint();
    }

    public void  addNextBlock(){

        int x = snakeElements.get(snakeElements.size()-1).positionX;
        int y = snakeElements.get(snakeElements.size()-1).positionY;
        Direction dir = snakeElements.get(snakeElements.size()-1).direction;

        snakeElements.add(new SnakeElement(x,y, dir));

    }
    /*
    public  void moveBodyBlock(){
        for (int i = snakeElements.size(); i > 1; i--) {
            int previousPositionX = snakeElements.get(i-2).positionX;
            int previousPositionY = snakeElements.get(i-2).positionY;
            snakeElements.get(i-1).positionX = previousPositionX;
            snakeElements.get(i-1).positionY = previousPositionY;
        }
    }

    public void moveHeadBlock(){
        Direction dir = snakeElements.get(0).direction;
        switch(dir){

            case UP:
                snakeElements.get(0).positionY -= SnakeElement.ELEMENT_SIZE;
                break;
            case DOWN:
                snakeElements.get(0).positionY += SnakeElement.ELEMENT_SIZE;
                break;
            case RIGHT:
                snakeElements.get(0).positionX += SnakeElement.ELEMENT_SIZE;
                break;
            case LEFT:
                snakeElements.get(0).positionX -= SnakeElement.ELEMENT_SIZE;
                break;
        }
    }
    */
    protected void turnRight() {
        Direction dir = snakeElements.get(0).direction;

        switch(dir){
            case UP:
                snakeElements.get(0).direction = Direction.RIGHT;
                break;
            case DOWN:
                snakeElements.get(0).direction = Direction.LEFT;
                break;
            case LEFT:
                snakeElements.get(0).direction = Direction.UP;
                break;
            case RIGHT:
                snakeElements.get(0).direction = Direction.DOWN;
                break;
        }
    }

    protected void turnLeft() {

        Direction dir = snakeElements.get(0).direction;

        switch (dir) {
            case UP:
                snakeElements.get(0).direction = Direction.LEFT;
                break;
            case DOWN:
                snakeElements.get(0).direction = Direction.RIGHT;
                break;
            case LEFT:
                snakeElements.get(0).direction = Direction.DOWN;
                break;
            case RIGHT:
                snakeElements.get(0).direction = Direction.UP;
                break;
        }
    }
}
