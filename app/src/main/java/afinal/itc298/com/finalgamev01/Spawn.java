package afinal.itc298.com.finalgamev01;

import java.util.Random;

/**
 * Created by jayke on 7/16/2017.
 */

public class Spawn {
    //this class creates enemies in sequences according to score and level
    //also sets the new level as the player progresses
    //every three levels an enemy boss will appear
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        hud.setScoreKeep(hud.getScoreKeep() + 1);//+1 each tick (the score for that level)

        //spawn sequences of enemy at each level
        if(hud.getLevel() == 1) {//LEVEL ONE
            if(hud.getScoreKeep()>= 650) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 100){
                //add enemy object
                handler.addObject(new BasicEnemy(r.nextInt(Constants.SCREEN_WIDTH-39), r.nextInt(Constants.SCREEN_HEIGHT),ID.BasicEnemy, handler));
            }
            if(hud.getScoreKeep() == 150){
                handler.addObject(new FastEnemyLR(Constants.SCREEN_WIDTH - 26,0,ID.FastEnemyLR, handler));
                handler.addObject(new FastEnemyLR(26,0,ID.FastEnemyLR, handler));
            }
        }else if(hud.getLevel() == 2){
            if(hud.getScoreKeep()>= 650) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 1){
                handler.clearEnemies();
            }
            int spawn = r.nextInt(30);
            if(spawn == 0)handler.addObject(new Asteroid((r.nextInt(Constants.SCREEN_WIDTH)), -150, ID.Asteroid, handler));
            if(hud.getScoreKeep() == 100){
                handler.addObject(new FastEnemy(Constants.SCREEN_WIDTH -26,0, ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(26,0, ID.FastEnemy, handler));
            }
        }else if(hud.getLevel() == 3){//BOSS LEVEL
            if(hud.getScoreKeep()>= 850) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 1){
                handler.clearEnemies();
            }
            if(hud.getScoreKeep() == 50){
                handler.addObject(new EnemyBoss((Constants.SCREEN_WIDTH/2), -500, ID.EnemyBoss, handler));
            }
        }else if(hud.getLevel() == 4){
            if(hud.getScoreKeep()>= 650) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 1){
                handler.clearEnemies();
            }
            if(hud.getScoreKeep() == 100)handler.addObject(new BasicEnemy(r.nextInt(Constants.SCREEN_WIDTH-39), r.nextInt(Constants.SCREEN_HEIGHT),ID.BasicEnemy, handler));
            if(hud.getScoreKeep() == 200)handler.addObject(new BasicEnemy(r.nextInt(Constants.SCREEN_WIDTH-39), r.nextInt(Constants.SCREEN_HEIGHT),ID.BasicEnemy, handler));
            if(hud.getScoreKeep() == 300){
                handler.addObject(new BasicEnemy(r.nextInt(Constants.SCREEN_WIDTH-39), r.nextInt(Constants.SCREEN_HEIGHT),ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Constants.SCREEN_WIDTH-39), r.nextInt(Constants.SCREEN_HEIGHT),ID.BasicEnemy, handler));
            }
            if(hud.getScoreKeep() == 50)handler.addObject(new FastEnemyLR(Constants.SCREEN_WIDTH/2, 0, ID.FastEnemyLR, handler));
        }else if(hud.getLevel() == 5){
            if(hud.getScoreKeep()>= 650) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 1){
                handler.clearEnemies();
            }
            int spawn = r.nextInt(15);
            if(spawn == 0)handler.addObject(new Asteroid((r.nextInt(Constants.SCREEN_WIDTH)), -150, ID.Asteroid, handler));
            if(hud.getScoreKeep() == 100){
                handler.addObject(new FastEnemyLR(Constants.SCREEN_WIDTH -26,0, ID.FastEnemyLR, handler));
                handler.addObject(new FastEnemyLR(26,0, ID.FastEnemyLR, handler));
            }
        }else if(hud.getLevel() == 6){//BOSS LEVEL
            if(hud.getScoreKeep()>= 850) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 1){
                handler.clearEnemies();
            }

            if(hud.getScoreKeep() == 50){
                handler.addObject(new SmartEnemy(r.nextInt(Constants.SCREEN_WIDTH-39), r.nextInt(Constants.SCREEN_HEIGHT),ID.SmartEnemy, handler));
                handler.addObject(new EnemyBoss2((Constants.SCREEN_WIDTH/2), -500, ID.EnemyBoss2, handler));
            }
        }else if(hud.getLevel() == 7){
            if(hud.getScoreKeep()>= 650) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 1){
                handler.clearEnemies();
            }

            if(hud.getScoreKeep() == 100){
                handler.addObject(new SmartEnemy(r.nextInt(Constants.SCREEN_WIDTH-39), r.nextInt(Constants.SCREEN_HEIGHT),ID.SmartEnemy, handler));
                handler.addObject(new FastEnemy(Constants.SCREEN_WIDTH/2, 0, ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(Constants.SCREEN_WIDTH/2,440 , ID.FastEnemy, handler));
                handler.addObject(new FastEnemyLR(Constants.SCREEN_WIDTH/2, 0, ID.FastEnemyLR, handler));
                handler.addObject(new FastEnemyLR(Constants.SCREEN_WIDTH/2,440 , ID.FastEnemyLR, handler));
            }
        }else if(hud.getLevel() == 8){//MINI BOSS
            if(hud.getScoreKeep()>= 750) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 1){
                handler.clearEnemies();
            }

            if(hud.getScoreKeep() == 100){
                handler.addObject(new SmartEnemy(r.nextInt(Constants.SCREEN_WIDTH-39), r.nextInt(Constants.SCREEN_HEIGHT),ID.SmartEnemy, handler));
                handler.addObject(new EnemyBossMini(-150, Constants.SCREEN_HEIGHT/2, ID.EnemyBoss, handler));
            }
        }else if(hud.getLevel() == 9){//FINAL BOSS
            if(hud.getScoreKeep()>= 750) {
                hud.setScoreKeep(0);
                hud.setLevel(hud.getLevel() + 1);//sets the new level
            }
            if(hud.getScoreKeep() == 1){
                handler.clearEnemies();
            }

            if(hud.getScoreKeep() == 100){
                handler.addObject(new EnemyBoss3((Constants.SCREEN_WIDTH)+(48*4), (Constants.SCREEN_HEIGHT/2)+280, ID.EnemyBoss3, handler));
                handler.addObject(new EnemyBoss3((Constants.SCREEN_WIDTH)+(48*2), (Constants.SCREEN_HEIGHT/2)+160, ID.EnemyBoss3, handler));
                handler.addObject(new EnemyBoss3((Constants.SCREEN_WIDTH)+(48*4), (Constants.SCREEN_HEIGHT/2)+40, ID.EnemyBoss3, handler));
            }
        }else if(hud.getLevel() == 10){
            int spawn = r.nextInt(30);
            if(spawn == 0)handler.addObject(new Asteroid((r.nextInt(Constants.SCREEN_WIDTH)), -150, ID.Asteroid, handler));
        }

    }
}
