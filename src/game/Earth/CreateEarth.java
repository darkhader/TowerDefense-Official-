/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Earth;

import base.GameObjManager;
import base.GameObject;

/**
 *
 * @author Hiep Nguyen
 */
public class CreateEarth extends GameObject {

    public CreateEarth() {
        Earth earth = new Earth();
        earth.position.set(1000, 285);
        GameObjManager.instance.add(earth);

    }

}
