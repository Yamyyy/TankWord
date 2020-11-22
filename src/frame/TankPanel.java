package frame;
import base.GameStatus;
import res.Map;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static frame.MainFrame.GAME_HEIGHT;
import static frame.MainFrame.GAME_WIDTH;


public class TankPanel extends JPanel{

    private GameStatus gameStatus;

    private Map map;

    public TankPanel(GameStatus gameStatus) {
        setBackground(Color.black);
        this.gameStatus = gameStatus;
        initGameStatus();
    }
    public void initGameStatus(){
        gameStatus.setProcess(GameStatus.Process.STARTING);
        map = new Map(gameStatus);
    }

    public void drawFrame(){


    }

    @Override
    public void paint(Graphics g) {


        switch (gameStatus.getProcess()){
            case STARTING:;
            case PLAYING:map.draw(g,gameStatus);
            case COUNTING:;
            case PAUSE:map.draw(g,gameStatus);
            case GAMEOVER:
                default:
        }


    }



    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            map.KeyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            map.keyReleased(e);
        }
    }

}

