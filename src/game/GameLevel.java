package game;

import city.cs.engine.World;



/**
 * Implement multiple game levels as an extension of the game world.
 */
public abstract class GameLevel extends World {
    private Rover rover;
    private Redstone redstone;
    private Meteor meteor;

    /**
     * Implements multiple game stages.
     * <p>
     * Implement the creation of multiple game stages through an abstract class.
     *
     * @param  game Current level that the main character is in.
     * @return Nothing.
     */

    // Game level constructor
    public GameLevel(Game game){
        // All levels have a rover, diamonds and last has falling meteors
        this.rover = new Rover(this);
        this.redstone = new Redstone(this);

        //meteor = new Meteor(this);

        // The rover has to collect the diamonds and reach the redstone to complete the level
        RedstoneCollection collection = new RedstoneCollection(this, game);
        rover.addCollisionListener(collection);
    }

    // Getter method that returns the rover (main character)
    public Rover getRover(){
        return rover;
    }
    // Getter method that returns the redstone (level transition body)
    public Redstone getRedstone(){
        return redstone;
    }
    // Getter method that returns the meteor (randomly generated body)
    public Meteor getMeteor(){
        return meteor;
    }

    // Empty method to specify level completion
    public abstract boolean isComplete();

    public abstract String getLevelName();
}
