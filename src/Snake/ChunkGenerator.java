package Snake;

import java.util.List;
import java.util.Random;

public class ChunkGenerator {
    
    static boolean chunkExist = false;
    int chunkPosX;
    int chunkPosY;

    public void generateChunkPosition (List<SnakeElement> snakeElementList){

        Random random = new Random();
        chunkPosX = random.nextInt(40)*SnakeElement.ELEMENT_SIZE;
        chunkPosY = random.nextInt(40)*SnakeElement.ELEMENT_SIZE;

        for (SnakeElement element : snakeElementList) {
            if (element.positionX == chunkPosX && element.positionY == chunkPosY){
                generateChunkPosition(snakeElementList);
            }
        }
    }
}
