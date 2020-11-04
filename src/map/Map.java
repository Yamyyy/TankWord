package map;

import base.BaseObject;
import bullet.Bullet;
import graph.ImageSet;
import graph.TankFrame;
import obstacle.Steel;
import tank.Tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Map {

    public List<BaseObject> objects = new ArrayList<>();

    public List<Tank> tankList = new ArrayList<>();

    public static final Map INSTANCE = new Map();

    public Map(){
        this.objects = new ArrayList<>();
        for (int i=0;i<20;i++){
            for (int j=0;j<10;j++){
                if (i!=0&&i!=19&&j!=0&&j!=9)continue;
                this.objects.add(new Steel(i*60,60*j));
            }

        }

    }

    public void draw(Graphics g) {
        for (int i=0;i<objects.size();i++){
            objects.get(i).draw(g);
        }
    }

    public boolean getMapObjectCollision(BaseObject object){


        for (BaseObject baseObject:objects){

            if (object.getX()==baseObject.getX()&&object.getY()== baseObject.getY())continue;

//            System.out.println(this.objects.size());
//            System.out.println(object.getX()+"++"+object.getY());
//
//            System.out.println(baseObject.getX()+"++"+baseObject.getY());
//            if (object.getX()>=baseObject.getX()&&object.getX()<=(baseObject.getX()+60)&&object.getY()>=baseObject.getY()&&object.getY()<=(baseObject.getY()+60)){
//                System.out.println("---");
//                return BaseObject.ObjectBlock(object,baseObject);
//            }

            Rectangle rect = new Rectangle(baseObject.getX(),baseObject.getY(), 60,60 );
            Rectangle rectTank = new Rectangle(object.getX(),object.getY(),60,60);
            if(rectTank.intersects(rect)){
                return BaseObject.ObjectBlock(object,baseObject);
            }
        }
        return false;
    }
}
