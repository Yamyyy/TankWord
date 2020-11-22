package tank;

import base.BaseObject;
import base.Dir;
import base.Group;
import base.TankType;
import bullet.Bullet;
import obstacle.Explode;
import res.ImageSet;
import res.Map;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tank extends BaseObject {

    private int speed;

    private int health;

    protected TankType tankType;

    protected Dir dir;
    private Group group;

    boolean moving;

     boolean bl = false,bu = false,br = false,bd = false;
     protected BufferedImage ImageU;
    protected BufferedImage ImageL;
    protected BufferedImage ImageD;
    protected BufferedImage ImageR;
    private Map map;
    protected int player;
    public Tank(Map map, int x, int y , Group group , Dir dir, TankType tankType, int player) {
        super(x, y, 50, 50, true, true, null);
        this.map = map;
        this.group = group;
        this.dir = dir;
        this.tankType = tankType;
        this.player = player;
        this.health = getTankTypeHealth(tankType);
        this.speed = getTankTypeSpeed(tankType);
        imageInit(tankType);
    }

    protected abstract void imageInit(TankType tankType);

    private int getTankTypeSpeed(TankType tankType){
        switch (tankType){
            case FAST:return 4;
            case HEAVY:return 1;
            case NORMAL:return 2;
            case PLAYER:return 1;
            default:return 2;
        }
    }

    private int getTankTypeHealth(TankType tankType){
        switch (tankType){
            case FAST:return 1;
            case HEAVY: return 3;
            case NORMAL:return 2;
            case PLAYER:return 2;
            default:return 1;
        }
    }


    public void move(){

        if (!moving)return;
        int tempX = getX();
        int tempY = getY();
        switch (dir) {
            case U:setY(getY()-speed);break;
            case D:setY(getY()+speed);break;
            case L:setX(getX()-speed);break;
            case R:setX(getX()+speed);break;
        }
        //TODO 体积碰撞

        //1.边界测试
        if (BaseObject.boundaryCheck(this)){
            setY(tempY);
            setX(tempX);
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

                //是否发生碰撞
                if(BaseObject.kickCheck(this,object)) {
                    //能相撞
                    //与bullet相撞
                    if (object instanceof Bullet&&group!=((Bullet) object).getGroup()){
                        beBulletCollision((Bullet)object);
                        object.beTankCollision(this);
                    }
                    //与其他物体碰撞
                    else {
                        setY(tempY);
                        setX(tempX);
                    }
                }

            }
        }
    }
    private BufferedImage getImage(Dir dir){

        switch (dir){
            case U:return this.ImageU;
            case D:return this.ImageD;
            case L:return this.ImageL;
            case R:return this.ImageR;
        }
        return ImageU;
    }

    public void draw(Graphics g){
        if (!isAlive())return;
        g.drawImage(getImage(dir),getX(),getY(),null);
        if (player==1||player==2)move();
        else {
            ((EnemyTank)this).randMove();
            ((EnemyTank) this).randFire();
        }
    }

    @Override
    public void beTankCollision(Tank tank) {

    }

    @Override
    public void beBulletCollision(Bullet bullet) {
        health--;
        if (health<=0){
            map.addPlayerCount(bullet.getPlayer());
            die();
        }
    }

    protected void fire(){
        map.addBullet(new Bullet(map,getX()+ 0.5*ImageU.getWidth()-0.5*ImageSet.BulletU.getWidth(),getY()+ 0.5*ImageU.getHeight()-0.5*ImageSet.BulletU.getHeight(),dir,group,player));
    }

    public void die(){
        setAlive(false);
        map.addExplode(new Explode(map,getX()+ 0.5*ImageU.getWidth()-0.5*ImageSet.explodes[0].getWidth(),getY()+ 0.5*ImageU.getHeight()-0.5*ImageSet.explodes[0].getWidth()));
    }

    public Group getGroup(){
        return group;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
