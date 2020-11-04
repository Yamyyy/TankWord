package tank;

import base.Dir;
import base.Group;
import bullet.Bullet;
import graph.ImageSet;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class PlayerTank extends Tank {

    public PlayerTank(int x,int y) {
        super();
        this.x = x;
        this.y = y;
        this.dir = Dir.U;
        this.group = Group.PLAYER;
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
        switch (key) {

            case KeyEvent.VK_J->{
                fire();
            }
            case KeyEvent.VK_UP -> {
                bu = true;
                moving=true;
            }
            case KeyEvent.VK_DOWN -> {
                bd = true;
                moving=true;
            }
            case KeyEvent.VK_LEFT -> {
                bl = true;
                moving=true;
            }
            case KeyEvent.VK_RIGHT -> {
                br = true;
                moving=true;
            }
            default ->{}
        }
        setRealDir();

    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_UP:bu = false;
            case KeyEvent.VK_DOWN:bd = false;
            case KeyEvent.VK_LEFT:bl = false;
            case KeyEvent.VK_RIGHT:br = false;
        }
        setRealDir();
    }
}
