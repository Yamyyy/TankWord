package obstacle;

import base.BaseObject;
import bullet.Bullet;
import res.ImageSet;
import tank.Tank;

import java.awt.*;

public class Wall extends BaseObject {

    public Wall(int x,int y){
        super(x,y,25,25,true,true, ImageSet.Wall);
    }

    @Override
    public void beTankCollision(Tank tank) {
    }

    @Override
    public void beBulletCollision(Bullet bullet) {
        setAlive(false);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getImage(),getX(),getY(),null);
    }
}
