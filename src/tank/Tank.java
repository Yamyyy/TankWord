package tank;

import base.BaseObject;
import base.Dir;
import base.Group;
import graph.ImageSet;
import graph.TankFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tank extends BaseObject {

    protected int speed = 2;

    protected Dir dir = Dir.U;
    protected Group group;

    private boolean live = true;

    protected boolean moving;
    protected boolean bl = false,bu = false,br = false,bd = false;


    protected void move(){
        if (!moving)return;
        int tempX = x;
        int tempY = y;
        switch (dir) {
            case U -> y -= speed;
            case D -> y += speed;
            case L -> x -= speed;
            case R -> x += speed;
        }
        if (TankFrame.INSTANCE.map.getMapObjectCollision(this)){
            x = tempX;y=tempY;
        }

    }
    private BufferedImage getImage(Dir dir){

        switch (dir){
            case U:return ImageSet.PlayerImageU;
            case D:return ImageSet.PlayerImageD;
            case L:return ImageSet.PlayerImageL;
            case R:return ImageSet.PlayerImageR;
        }
        return ImageSet.PlayerImageU;
    }

    public void draw(Graphics g){
        if (!this.live)return;
        g.drawImage(getImage(dir),x,y,null);
        move();

    }

    protected void fire(){
        TankFrame.INSTANCE.addBullet(x+ 0.5*ImageSet.PlayerImageU.getWidth()-0.5*ImageSet.BulletU.getWidth(),y+ 0.5*ImageSet.PlayerImageU.getHeight()-0.5*ImageSet.BulletU.getHeight(),dir,group);
    }

    public void die(){
        live = false;
    }

    public boolean getLive(){
        return this.live;
    }

    public void setLive(boolean live){
        this.live = live;
    }

    public Group getGroup(){
        return group;
    }
}
