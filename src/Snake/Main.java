package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {

    static Board board = new Board();
    Rectangle boardBounds;
    static double boardMaxX;
    static double boardMaxY;

    public Main(){
        this.setBounds(400, 200, 416, 439);
        this.setResizable(false);
        this.add(board);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    board.turnLeft();
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    board.turnRight();
                }
            }
        });

        this.setVisible(true);
        boardBounds = board.getBounds();
        boardMaxX = boardBounds.getMaxX();
        boardMaxY = boardBounds.getMaxY();
    }

    public static void main(String[] args) {
        new Main();
    }
}



