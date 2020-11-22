package obstacle;

import base.BaseObject;
import bullet.Bullet;
import res.ImageSet;
import tank.Tank;

import java.awt.*;

public class Basement extends BaseObject {


    public Basement(int x, int y) {
        super(x, y, 50, 50, true,true, ImageSet.Basement);
    }

    @Override
    public void beTankCollision(Tank tank) {

    }

    @Override
    public void beBulletCollision(Bullet bullet) {

    }

    @Override
    public void draw(Graphics g) {

    }
}
