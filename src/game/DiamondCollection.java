package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;



/**
 * Implement a collision listener to remove the intermediate loot from the game world.
 */
public class DiamondCollection implements CollisionListener {

    private Rover rover;
    public DiamondCollection(Rover r) {

        this.rover = r;

    }


    @Override
    public void collide(CollisionEvent d) {
        if (d.getOtherBody() instanceof Diamond) {
            this.rover.addDiamond();
            d.getOtherBody().destroy();
            this.rover.addEatenDiamond(d.getOtherBody().getPosition());
        }
    }
}
