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
public class CreateMeteor extends GameObject {

    private Random random = new Random();

    public CreateMeteor() {

        this.ConfigAction();

    }

    public void ConfigAction() {
        this.addAction(
                new SequenceAction(new WaitAction(500),
                        new LimitAction(22,
                                new SequenceAction(
                                        new WaitAction(200),
                                        new ActionAdapter() {
                                    public boolean run(GameObject owner) {
                                        if (KeyBoardInput.instance.isSpace) {
                                            Meteor meteor = GameObjManager.instance.recycle(Meteor.class);
                                            meteor.position.set(0, 280);

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
