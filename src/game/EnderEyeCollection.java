package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;



/**
 * Implement a collision listener to remove the bonus loot from the game world.
 */
public class EnderEyeCollection implements CollisionListener {

    private Rover rover;

    public EnderEyeCollection(Rover r) {

        this.rover = r;
    }


    // Implement body destruction through collision
    @Override
    public void collide(CollisionEvent d) {
        if (d.getOtherBody() instanceof EnderEye) {
            rover.addEye();
            d.getOtherBody().destroy();
        }
    }
}
