/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import base.Attribute;
import base.GameObjManager;
import input.KeyBoardInput;
import tower.Snow.Goku;
import tower.machineGun.MachineGun;
import tower.missile.MissileGun;
import tower.tinker.Fire;


/**
 *
 * @author Hiep Nguyen
 */
public class PlayerBuild implements Attribute<Player> {

    public static int n = 1;
    public static int m = 1;
    public static int l = 1;
    public static int i = 1;
    public static float a,b,c,d,e,f,g,h ;
   
    public static PlayerBuild instance = new PlayerBuild();

    @Override
    public void run(Player gameObject) {
        if (KeyBoardInput.instance.is1 && n != 0 &&  GameObjManager.instance.allEnemyDied >=25 ) {
            a = gameObject.position.x;
            b = gameObject.position.y;
            GameObjManager.instance.recycle(MachineGun.class);
            n = n - 1;
            GameObjManager.instance.allEnemyDied -=25;

        }
        if (KeyBoardInput.instance.is2 && m != 0 &&  GameObjManager.instance.allEnemyDied >=50) {
            c = gameObject.position.x;
            d = gameObject.position.y;
            GameObjManager.instance.recycle(Fire.class);
            m = m - 1;
             GameObjManager.instance.allEnemyDied -=50;


        }
        if (KeyBoardInput.instance.is3 && l != 0 &&  GameObjManager.instance.allEnemyDied >=50) {
            e = gameObject.position.x;
            f = gameObject.position.y;
             GameObjManager.instance.recycle(MissileGun.class);
            l = l - 1;
                 GameObjManager.instance.allEnemyDied -=50;

        }
        if (KeyBoardInput.instance.is4 && i != 0 &&  GameObjManager.instance.allEnemyDied >=100) {
            g = gameObject.position.x;
            h = gameObject.position.y;
             GameObjManager.instance.recycle(Goku.class);
            i = i - 1;
                 GameObjManager.instance.allEnemyDied -=100;

        }

    }

}
