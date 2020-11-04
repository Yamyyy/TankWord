package graph;

import base.BaseObject;
import base.Dir;
import base.Group;
import bullet.Bullet;
import map.Map;
import tank.EnemyTank;
import tank.PlayerTank;
import tank.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class TankFrame extends Frame{

    public static final int GAME_WIDTH = 1200,GAME_HEIGHT = 600;

    public static final TankFrame INSTANCE = new TankFrame();

    public PlayerTank playerTank = new PlayerTank(120,120);


    public List<EnemyTank> enemyTankList = new ArrayList<>();

    public List<Bullet> bulletList = new ArrayList<>();

    public Map map = Map.INSTANCE;

    public TankFrame() {

        EnemyTank enemyTank = new EnemyTank(240,150);
        enemyTankList.add(enemyTank);

        map.tankList.addAll(enemyTankList);
        map.tankList.add(playerTank);
        map.objects.addAll(map.tankList);

//        map.objects.addAll(bulletList);
    }
    public void drawFrame(){

        this.setLocation(100,50);
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        this.setTitle("坦克大战");

        this.addKeyListener(new TankKeyListener());
    }

    @Override
    public void paint(Graphics g) {

        map.draw(g);
        System.out.println(bulletList.size());
        for(int i = 0; i<bulletList.size();i++){
            for (int j = 0;j<map.tankList.size();j++){
                bulletList.get(i).collidesWithTank(map.tankList.get(j));
            }
            for (int j = 0;j<map.objects.size();j++){
                bulletList.get(i).collidesWithBlock(map.objects.get(j));
            }
            if (!bulletList.get(i).isLive())bulletList.remove(i);
            else if (BaseObject.boundaryCheck(bulletList.get(i)))bulletList.remove(i);
            else if (map.getMapObjectCollision(bulletList.get(i)));
            else bulletList.get(i).draw(g);
        }
        for(int i=0;i<enemyTankList.size();i++){
            if (enemyTankList.get(i).getLive()){
                enemyTankList.get(i).randFire();
                enemyTankList.get(i).randMove();
            }
            enemyTankList.get(i).draw(g);
        }
        playerTank.draw(g);

    }

    Image offscreenImage = null;

    @Override
    public void update(Graphics g) {
        if(offscreenImage == null){
            offscreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offscreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offscreenImage,0,0,null);
    }

    private class TankKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            playerTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            playerTank.keyReleased(e);
        }
    }

    public void addBullet(double x, double y, Dir dir, Group group){
        this.bulletList.add(new Bullet(x,y,dir,group));
    }
}

