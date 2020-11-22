package tank;

import base.Dir;
import base.Group;
import base.TankType;
import res.ImageSet;
import res.Map;
import utils.Rand;

import java.util.Random;

public class EnemyTank extends Tank{

    private int step;

    private int fireTime;


    public EnemyTank(Map map,int x, int y, TankType tankType) {
        super(map,x,y,Group.ENEMY,Dir.U,tankType,0);
    }



    public void randMove(){
        if (step!=0) {
            move();
            step--;
        }
        else {
            moving = true;
            dir = Rand.randDir();
            step = new Random().nextInt(100)+5;
        }
    }
    public void randFire(){
        if (fireTime==0){
            fire();
            fireTime = new Random().nextInt(100)+10;
        }
        else {
            fireTime--;
        }
    }

    @Override
    protected void imageInit(TankType tankType) {
        if(tankType==TankType.NORMAL){
            ImageU = ImageSet.Enemy1ImageU;
            ImageD = ImageSet.Enemy1ImageD;
            ImageL = ImageSet.Enemy1ImageL;
            ImageR = ImageSet.Enemy1ImageR;
        }
        else if(tankType==TankType.FAST){
            ImageU = ImageSet.Enemy2ImageU;
            ImageD = ImageSet.Enemy2ImageD;
            ImageL = ImageSet.Enemy2ImageL;
            ImageR = ImageSet.Enemy2ImageR;
        }
        else if(tankType==TankType.HEAVY){
            this.ImageU = ImageSet.Enemy3ImageU;
            this.ImageD = ImageSet.Enemy3ImageD;
            this.ImageL = ImageSet.Enemy3ImageL;
            this.ImageR = ImageSet.Enemy3ImageR;
        }
    }
}
