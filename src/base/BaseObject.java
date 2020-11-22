package base;

import bullet.Bullet;
import frame.MainFrame;
import res.Map;
import tank.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class BaseObject {

    private Map map;

    private boolean objectBlock;

    private boolean bulletBlock;

    private boolean alive = true;

    private int x;

    private int width;

    private int y;

    private int height;

    private BufferedImage image;

    public BaseObject(int x, int y, int width , int height,boolean objectBlock,boolean bulletBlock,BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.objectBlock = objectBlock;
        this.bulletBlock = bulletBlock;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void beTankCollision(Tank tank);
    public abstract void beBulletCollision(Bullet bullet);

    public static boolean boundaryCheck(BaseObject baseObject){

        if (baseObject.x < 0)return true;
        else if (baseObject.x+baseObject.getWidth() > MainFrame.GAME_WIDTH)return true;
        else if (baseObject.y+baseObject.getHeight() > MainFrame.GAME_HEIGHT)return true;
        else if (baseObject.y < 0)return true;
        else return false;
    }


    public static boolean kickCheck(BaseObject object1,BaseObject object2){

        Rectangle rect1 = new Rectangle(object1.getX(), object1.getY(), object1.getWidth(),object1.getHeight());
        Rectangle rect2 = new Rectangle(object2.getX(), object2.getY(), object2.getWidth(), object2.getHeight());
        if (rect1.intersects(rect2)) {
            return true;
        }
        else return false;
    }

    /**
     * 两个物体是否能碰撞
     * @param object1
     * @param object2
     * @return
     */
    public static boolean ObjectBlock(BaseObject object1,BaseObject object2){
        //1.如果其中一个是炮弹
        if(object1 instanceof Bullet||object2 instanceof Bullet)return object1.isBulletBlock()&&object2.isBulletBlock();
        //2.都不是炮弹
        else return object1.isObjectBlock()&&object2.isObjectBlock();
    }


    public abstract void draw(Graphics g);

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public boolean isObjectBlock() {
        return objectBlock;
    }

    public boolean isBulletBlock() {
        return bulletBlock;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getHeight() {
        return height;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }


    public int getWidth() {
        return width;
    }

    public BufferedImage getImage() {
        return image;
    }
}
