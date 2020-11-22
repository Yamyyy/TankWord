package bullet;


import base.BaseObject;
import base.Dir;
import base.Group;
import res.ImageSet;
import res.Map;
import tank.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends BaseObject {

    private int speed;
    private Dir dir;
    private Group group;
    private Map map;
    private int player;

    public Bullet(Map map,double x, double y, Dir dir, Group group,int player){
        super((int)x,(int)y,10,10,true,true,null);
        this.map = map;
        this.dir = dir;
        this.group = group;
        this.speed = 4;
        this.player = player;
    }

    @Override
    public void beTankCollision(Tank tank) {
        setAlive(false);
    }

    @Override
    public void beBulletCollision(Bullet bullet) {
        die();
    }

    private void die() {
        setAlive(false);
    }

    public void draw(Graphics g){
        if (!isAlive())return;
        move();
        g.drawImage(getImage(dir),getX(),getY(),null);
    }

    private BufferedImage getImage(Dir dir){

        switch (dir){
            case U:return ImageSet.BulletU;
            case D:return ImageSet.BulletD;
            case L:return ImageSet.BulletL;
            case R:return ImageSet.BulletR;
        }
        return ImageSet.BulletU;
    }
    private void move(){
        switch (dir){
            case U:setY(getY()-speed); ;break;
            case D:setY(getY()+speed);break;
            case L:setX(getX()-speed);break;
            case R:setX(getX()+speed);break;
        }
        //1.边界测试
        if (BaseObject.boundaryCheck(this)){
            setAlive(false);
        }
        else{

            //物体碰撞测试 是否能相撞
            for(BaseObject object:map.getBaseObjects()){

                //判断是否是自己
                if (this == object)
                    continue;  //先判断o是否为本对象，this 指向当前的对象
                //物体是否存活
                if (!this.isAlive()&&!object.isAlive())continue;

                //同group bullet不做处理
                if (object instanceof Bullet&&((Bullet) object).getGroup()==this.getGroup())continue;

                //同group tank不做处理
                if (object instanceof Tank&&((Tank) object).getGroup()==this.getGroup())continue;

                //是否发生碰撞
                if(BaseObject.kickCheck(this,object)) {
                    //能相撞
                    //与bullet相撞
                    if (object instanceof Bullet&&group!=((Bullet) object).getGroup()){
                        beBulletCollision((Bullet)object);
                        object.beBulletCollision(this);
                    }
                    else {
                        beBulletCollision(this);
                        object.beBulletCollision(this);
                    }
                }

            }
        }
    }


    public Group getGroup() {
        return group;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
}
