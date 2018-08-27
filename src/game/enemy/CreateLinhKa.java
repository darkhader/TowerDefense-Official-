/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.enemy;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObjManager;
import base.GameObject;
import input.KeyBoardInput;
import java.util.Random;

/**
 *
 * @author Hiep Nguyen
 */
public class CreateLinhKa extends GameObject {



    private Random random = new Random();

    public CreateLinhKa() {
          
            this.ConfigAction();
        
    }

    public void ConfigAction() {
        this.addAction(
                new SequenceAction(new WaitAction(1000),
                        new LimitAction(8,
                                new SequenceAction(
                                        new WaitAction(500),
                                        new ActionAdapter() {
                                    public boolean run(GameObject owner) {
                                        if(KeyBoardInput.instance.isSpace){
                                        LinhKa linhka = GameObjManager.instance.recycle(LinhKa.class);
                                        linhka.position.set(0, 300);
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
