package game.enemyMap2;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObjManager;
import base.GameObject;
import input.KeyBoardInput;


import java.util.Random;

public class CreateLinhKaMap2 extends GameObject {
    private Random random = new Random();

    public CreateLinhKaMap2() {
        this.ConfigAction();
    }

    public void ConfigAction() {
        this.addAction(
                new SequenceAction(new WaitAction(10),
                        new LimitAction(20,
                                new SequenceAction(
                                        new WaitAction(400),
                                        new ActionAdapter() {
                                            public boolean run(GameObject owner) {
                                                 if(KeyBoardInput.instance.isSpace){
                                                LinhKaMap2 linhka2 = GameObjManager.instance.recycle(LinhKaMap2.class);
                                                linhka2.position.set(0, 300);
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
