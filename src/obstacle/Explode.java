package obstacle;

import base.BaseObject;
import bullet.Bullet;
import res.ImageSet;
import res.Map;
import tank.Tank;

import java.awt.*;

public class Explode extends BaseObject {

    private int step = 0;

    public Explode(Map map, double x, double y){
        super((int )x,(int)y,50,50,false,false,null);
    }

    @Override
    public void beTankCollision(Tank tank) {

    }

    @Override
    public void beBulletCollision(Bullet bullet) {

    }

    public void draw(Graphics g){
        if(isAlive()) {
            g.drawImage(ImageSet.explodes[step], getX(), getY(), null);
            this.step++;
            if (step == ImageSet.explodes.length) {
                setAlive(false);
            }
        }

    }
}
