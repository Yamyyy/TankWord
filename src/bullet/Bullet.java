package bullet;


import base.BaseObject;
import base.Dir;
import base.Group;
import graph.ImageSet;
import graph.TankFrame;
import tank.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends BaseObject {

    private int speed = 10;
    private Dir dir;
    private boolean live = true;
    private Group group; //true is good


    public Bullet(int x,int y,Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public Bullet(double x,double y,Dir dir,Group group){
        this.x = (int)x;
        this.y = (int)y;
        this.dir = dir;
        this.group = group;
    }

    public void draw(Graphics g){
        move();
        g.drawImage(getImage(dir),x,y,null);
    }

    private BufferedImage getImage(Dir dir){

        switch (dir){
            case U:return ImageSet.BulletU;
            case D:return ImageSet.BulletD;
            case L:return ImageSet.BulletL;
            case R:return ImageSet.BulletR;
        }
        return ImageSet.PlayerImageU;
    }
    private void move(){
        switch (dir){
            case U:y -= speed;break;
            case D:y += speed;break;
            case L:x -= speed;break;
            case R:x += speed;break;
        }


    }

    public void collidesWithTank(Tank tank){

        System.out.println(group+"----"+tank.getGroup());
        if (!tank.getLive())return;
        if (group.equals(tank.getGroup()))return;

        Rectangle rect = new Rectangle(x,y, ImageSet.BulletU.getWidth(),ImageSet.BulletU.getWidth() );
        Rectangle rectTank = new Rectangle(tank.getX(),tank.getY(),ImageSet.PlayerImageU.getWidth(),ImageSet.PlayerImageU.getHeight());
        if(rect.intersects(rectTank)){
            this.setLive(false);
            tank.die();
        }
    }
    public void collidesWithBlock(BaseObject object){

        if (object instanceof Tank)return;


        for (BaseObject baseObject:TankFrame.INSTANCE.map.objects) {
            Rectangle rect = new Rectangle(baseObject.getX(), baseObject.getY(), 60, 60);
            Rectangle rectTank = new Rectangle(this.getX(), this.getY(), 60, 60);
            if (rectTank.intersects(rect)) {
                if(BaseObject.ObjectBlock(object, baseObject))
                    this.setLive(false);
                baseObject.beCollide();
            }
        }
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
