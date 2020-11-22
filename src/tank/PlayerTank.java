package tank;

import base.Dir;
import base.Group;
import base.TankType;
import res.ImageSet;
import res.Map;

import java.awt.event.KeyEvent;


public class PlayerTank extends Tank {

    //1为主玩家 2为副玩家

    public PlayerTank(Map map,int x, int y, int player){

        super(map,x,y,Group.PLAYER,Dir.U, TankType.PLAYER,player);
    }

    private void setRealDir(){
        if(bl&!br&!bu&!bd)dir = Dir.L;
        else if(!bl&br&!bu&!bd)dir = Dir.R;
        else if(!bl&!br&bu&!bd)dir = Dir.U;
        else if(!bl&!br&!bu&bd)dir = Dir.D;
        else if(!bl&!br&!bu&!bd)moving = false;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (player == 1) {
            switch (key) {
                case KeyEvent.VK_J: {
                    fire();
                    break;
                }
                case KeyEvent.VK_W: {
                    bu = true;
                    moving = true;
                    break;
                }
                case KeyEvent.VK_S: {
                    bd = true;
                    moving = true;
                    break;
                }
                case KeyEvent.VK_A: {
                    bl = true;
                    moving = true;
                    break;
                }
                case KeyEvent.VK_D: {
                    br = true;
                    moving = true;
                    break;
                }
                default: {
                }
            }
        }
        else if(player == 2){
            switch (key) {
                case KeyEvent.VK_L: {
                    fire();
                    break;
                }
                case KeyEvent.VK_UP: {
                    bu = true;
                    moving = true;
                    break;
                }
                case KeyEvent.VK_DOWN: {
                    bd = true;
                    moving = true;
                    break;
                }
                case KeyEvent.VK_LEFT: {
                    bl = true;
                    moving = true;
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    br = true;
                    moving = true;
                    break;
                }
                default: {
                }
            }
        }
        setRealDir();
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (player == 1) {
            switch (key) {
                case KeyEvent.VK_W:
                    bu = false;
                    break;
                case KeyEvent.VK_S:
                    bd = false;
                    break;
                case KeyEvent.VK_A:
                    bl = false;
                    break;
                case KeyEvent.VK_D:
                    br = false;
                    break;
            }
        }
        else if (player == 2) {
            switch (key) {
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_LEFT:
                   bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
            }
        }
        setRealDir();
    }

    @Override
    protected void imageInit(TankType tankType) {

        if(player==1){

            ImageU = ImageSet.Player1ImageU;
            ImageD = ImageSet.Player1ImageD;
            ImageL = ImageSet.Player1ImageL;
            ImageR = ImageSet.Player1ImageR;
        }
        else if(player==2){
           ImageU = ImageSet.Player2ImageU;
           ImageD = ImageSet.Player2ImageD;
            ImageL = ImageSet.Player2ImageL;
            ImageR = ImageSet.Player2ImageR;
        }

    }
}
