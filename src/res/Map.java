package res;

import base.BaseObject;
import base.GameStatus;
import base.TankType;
import bullet.Bullet;
import obstacle.Explode;
import tank.EnemyTank;
import tank.PlayerTank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<BaseObject> baseObjects = new ArrayList<>();

    private List<PlayerTank> playerTankList = new ArrayList<>();

    private List<Bullet> bulletList = new ArrayList<>();

    private GameStatus gameStatus;

    public Map(GameStatus gameStatus){
        this.gameStatus = gameStatus;
        initMap(gameStatus);
    }

    private void initMap(GameStatus gameStatus){

        //载入地图
        baseObjects = MapSet.readMap(gameStatus.getMap()+"");
        if(gameStatus.getPlayerNumber()==2){
            playerTankList.add(new PlayerTank(this,1000,500,1));
        }
        else{
            playerTankList.add(new PlayerTank(this,1000,400,1));
            playerTankList.add(new PlayerTank(this,1000,500,2));
        }
        baseObjects.addAll(playerTankList);

        baseObjects.add(new EnemyTank(this,1000,200, TankType.HEAVY));
    }


    public void draw(Graphics g,GameStatus gameStatus) {
        for (int i=0; i<baseObjects.size() ; i++){
            if (!baseObjects.get(i).isAlive())baseObjects.remove(i);
            else baseObjects.get(i).draw(g);
        }
    }

    public void addBullet(Bullet bullet){
        baseObjects.add(bullet);
    }

    public void addExplode(Explode explode){
        baseObjects.add(explode);
    }


    public void KeyPressed(KeyEvent e) {
        //TODO 界面判断
       playerTankList.forEach(t->t.keyPressed(e));
    }

    public void keyReleased(KeyEvent e) {
        playerTankList.forEach(t->t.keyReleased(e));
    }

    public List<BaseObject> getBaseObjects() {
        return baseObjects;
    }

    public void addPlayerCount(int player){
        if (player==1)gameStatus.setPlayerCount1(gameStatus.getPlayerCount1()+1);
        else if (player==2)gameStatus.setPlayerCount2(gameStatus.getPlayerCount2()+1);
    }
}
