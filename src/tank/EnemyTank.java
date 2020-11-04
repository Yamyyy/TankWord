package tank;

import base.Dir;
import base.Group;
import utils.Rand;

import java.util.Random;

public class EnemyTank extends Tank{

    private int step;

    private int fireTime;

    public EnemyTank(int x,int y) {
        super();
        this.x = x;
        this.y = y;
        this.dir = Dir.U;
        this.group = Group.ENEMY;
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
}
