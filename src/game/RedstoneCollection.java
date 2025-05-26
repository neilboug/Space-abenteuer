package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;



/**
 * Implement a collision listener to remove to transition from a one game stage to another.
 */
public class RedstoneCollection implements CollisionListener {

    private Game game;
    private GameLevel level;

    public RedstoneCollection(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent e) {
        // If the rover collide with the redstone and the
        // level completion conditions are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Redstone
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}
