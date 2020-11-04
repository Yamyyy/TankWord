package base;

import graph.ImageSet;
import graph.TankFrame;
import tank.Tank;

import java.awt.*;

public abstract class BaseObject {

    protected TankFrame tankFrame;

    protected boolean block = true;

    protected boolean live = true;

    protected int x;

    protected int y;

    public boolean kick() {

        return block;
    }

    public BaseObject(){
        this.tankFrame = TankFrame.INSTANCE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static boolean boundaryCheck(BaseObject baseObjectobj){
        if (baseObjectobj.x < 0)return true;
        else if (baseObjectobj.x > TankFrame.GAME_WIDTH)return true;
        else if (baseObjectobj.y > TankFrame.GAME_HEIGHT)return true;
        else if (baseObjectobj.y < 30)return true;
        else return false;
    }

    public static boolean ObjectBlock(BaseObject object1,BaseObject object2){
        if (!object1.block)return false;
        else if(!object2.block)return false;
        else return true;
    }

    public void draw(Graphics g){
    }

    public void beCollide() {

    }
}
