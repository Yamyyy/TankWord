package obstacle;

import base.BaseObject;
import bullet.Bullet;
import res.ImageSet;
import tank.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class River  extends BaseObject {


    public River(int x, int y) {
        super(x, y,50, 50, true, false,ImageSet.River);
    }

    @Override
    public void beTankCollision(Tank tank) {
    }

    @Override
    public void beBulletCollision(Bullet bullet) {
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getImage(),getX(),getY(),null);
    }

}
