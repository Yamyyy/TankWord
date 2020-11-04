package obstacle;

import base.BaseObject;
import graph.ImageSet;

import java.awt.*;

public class Steel extends BaseObject {

    public Steel(int x,int y){
        super();
        this.x = x;
        this.y = y;
    }
    public void say(){
        System.out.println("this is steel");
    }

     public void draw(Graphics g){
         g.drawImage(ImageSet.Steel,x,y,null);
     }

     public void beCollide(){
     }
}
