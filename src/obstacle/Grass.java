package obstacle;

import base.BaseObject;
import bullet.Bullet;
import res.ImageSet;
import tank.Tank;

import java.awt.*;

public class Grass extends BaseObject {

    private int width = 25;

    private int height = 25;

    private boolean objectBlock = false;

    private boolean bulletBlock = false;


    public Grass(int x, int y){
        super(x,y,25,25,true,true, ImageSet.Grass);
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


    public boolean isObjectBlock() {
        return objectBlock;
    }

    public int getHeight() {
        return height;
    }


    public int getWidth() {
        return width;
    }

    public boolean isBulletBlock() {
        return bulletBlock;
    }
}
