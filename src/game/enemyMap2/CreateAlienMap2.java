package game.enemyMap2;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObjManager;
import base.GameObject;
import input.KeyBoardInput;


import java.util.Random;

public class CreateAlienMap2 extends GameObject{
    private Random random = new Random();

    public CreateAlienMap2() {
        this.ConfigAction();
    }

    public void ConfigAction() {
        this.addAction(
                new LimitAction(1000,
                        new SequenceAction(
                                new WaitAction(10),
                                new ActionAdapter() {
                                    public boolean run(GameObject owner) {
                                        if(KeyBoardInput.instance.isSpace){
                                        AlienMap2 alienMap2 = new AlienMap2();
                                        alienMap2.position.set(0, random.nextInt(30)+270);
                                        GameObjManager.instance.add(alienMap2);
                                        return true;
                                        }
                                        return false;
                                        
                                    }

                                }
                        )
                )
        );
    }
}
