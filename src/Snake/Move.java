package Snake;

import java.util.List;

public class Move {


    public void isHeadOutOfBounds(){
        if(Board.snakeElements.get(0).positionX == Main.boardMaxX) {
            Board.snakeElements.get(0).positionX = 0;
        }
        else if(Board.snakeElements.get(0).positionY == Main.boardMaxY){
            Board.snakeElements.get(0).positionY = 0;
        }
        else if(Board.snakeElements.get(0).positionX == 0 - SnakeElement.ELEMENT_SIZE){
            Board.snakeElements.get(0).positionX = (int)Main.boardMaxX - SnakeElement.ELEMENT_SIZE;
        }
        else if(Board.snakeElements.get(0).positionY == 0 - SnakeElement.ELEMENT_SIZE){
            Board.snakeElements.get(0).positionY = (int)Main.boardMaxY - SnakeElement.ELEMENT_SIZE;
        }
    }

    public void snakeEatChunk(ChunkGenerator chunk){
        if (Board.snakeElements.get(0).positionX == chunk.chunkPosX && Board.snakeElements.get(0).positionY == chunk.chunkPosY){
            chunk.generateChunkPosition(Board.snakeElements);
            Main.board.addNextBlock();
        }
    }

    public void snakeEatSnake(){
        SnakeElement head = Board.snakeElements.get(0);
        for (int i = 1; i < Board.snakeElements.size(); i++) {
            if (head.positionX == Board.snakeElements.get(i).positionX && head.positionY == Board.snakeElements.get(i).positionY){
                Main.board.timer.stop();
            }
        }
    }

    public void moveHeadBlock(){
        Direction dir = Board.snakeElements.get(0).direction;
        switch(dir){

            case UP:
                Board.snakeElements.get(0).positionY -= SnakeElement.ELEMENT_SIZE;
                break;
            case DOWN:
                Board.snakeElements.get(0).positionY += SnakeElement.ELEMENT_SIZE;
                break;
            case RIGHT:
                Board.snakeElements.get(0).positionX += SnakeElement.ELEMENT_SIZE;
                break;
            case LEFT:
                Board.snakeElements.get(0).positionX -= SnakeElement.ELEMENT_SIZE;
                break;
        }
    }

    public  void moveBodyBlock(){
        for (int i = Board.snakeElements.size(); i > 1; i--) {
            int previousPositionX = Board.snakeElements.get(i-2).positionX;
            int previousPositionY = Board.snakeElements.get(i-2).positionY;
            Board.snakeElements.get(i-1).positionX = previousPositionX;
            Board.snakeElements.get(i-1).positionY = previousPositionY;
        }
    }
}
