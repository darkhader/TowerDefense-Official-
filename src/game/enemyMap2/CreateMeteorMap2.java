package game.enemyMap2;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObjManager;
import base.GameObject;
import input.KeyBoardInput;


import java.util.Random;

public class CreateMeteorMap2 extends GameObject {
    private Random random = new Random();

    public CreateMeteorMap2() {
        this.ConfigAction();
    }

    public void ConfigAction() {
        this.addAction(
                new SequenceAction(new WaitAction(10),
                        new LimitAction(20,
                                new SequenceAction(
                                        new WaitAction(200),
                                        new ActionAdapter() {
                                            public boolean run(GameObject owner) {
                                                 if(KeyBoardInput.instance.isSpace){
                                                MeteorMap2 meteorMap2 = GameObjManager.instance.recycle(MeteorMap2.class);
                                                meteorMap2.position.set(0, 280);
                                                return true;
                                                 }
                                                return false;
                                            }

                                        }
                                )
                        )
                )
        );
    }
}
