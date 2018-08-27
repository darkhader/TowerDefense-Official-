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


public class CreateAlien extends GameObject {

 

    private Random random = new Random();

    public CreateAlien() {
        
            this.ConfigAction();
        
        
        
    }

    public void ConfigAction() {
        this.addAction(
                new LimitAction(500,
                        new SequenceAction(
                                new WaitAction(10),
                                new ActionAdapter() {
                            public boolean run(GameObject owner) {
                                if(KeyBoardInput.instance.isSpace){
                                Alien alien = new Alien();
                                alien.position.set(0, random.nextInt(30)+270);
                                GameObjManager.instance.add(alien);
                                return true; 
                                } else
                                return false;
                            }

                        }
                        )
                )
        );
    }
}
