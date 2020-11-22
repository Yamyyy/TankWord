package obstacle;

import base.BaseObject;
import bullet.Bullet;
import res.ImageSet;
import tank.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Iron extends BaseObject {

    public Iron(int x,int y){
        super(x,y,25,25,true,true,ImageSet.Iron);
    }

    @Override
    public void beTankCollision(Tank tank) {
    }

    @Override
    public void beBulletCollision(Bullet bullet) {
    }

    public void draw(Graphics g){
         g.drawImage(getImage(),getX(),getY(),null);
     }

}
