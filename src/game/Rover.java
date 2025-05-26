package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;
import java.util.List;



/**
 * Add a dynamic body to the game world; main game character .
 */
public class Rover extends Walker {
    private static final Shape roverShape = new PolygonShape(
            -1.5f, 1.49f,
            -1.85f, -1.47f,
            1.89f, -1.32f,
            1.29f, 0.23f
    );


    // Add an image to the rover's shape
    private static final BodyImage image =
            new BodyImage("data/curiosity_rover.png", 3f);

    private int eyeCount;
    private int heartCount;
    private int meteorCount;
    private int diamondCount;

    private List<Vec2> eatenDiamond = new ArrayList<>();


    private World world;

    public Rover(World world) {
        super(world, roverShape);
        this.world = world;
        addImage(image);

        eyeCount = 0;
        heartCount = 3;
        meteorCount = 0;
        diamondCount = 0;
    }



    // Keeps track of the number of collected Ender-Eyes
    public void addEye(){
        eyeCount++;
        System.out.println("You have collected: "
                + eyeCount + " endereye(s).");
    }
    // Keeps track of the number of destroyed meteors
    public void subLife(){
        heartCount--;
        System.out.println("You have: "
                + heartCount + " lives left.");
    }
    // Keeps track of the number of destroyed meteors
    public void addMeteor(){
        meteorCount++;
        System.out.println("You have successfully destroyed: "
                + meteorCount + " meteor(s).");
    }
    // Keeps track of the number of collected diamonds
    public void addDiamond(){
        diamondCount++;
        System.out.println("You have collected: "
                + diamondCount + " diamond(s).");
    }

    public void setDiamondCount(int dc){
        diamondCount = dc;
    }

    // Getter method that keeps track of the number of bonus loot collected
    public int getEyeCount() {
        return eyeCount;
    }
    // Getter method that keeps track of the lives left
    public int getLifeCount() {
        return heartCount;
    }
    // Getter method that keeps track of the number of destroyed meteors
    public int getMeteorCount() {
        return meteorCount;
    }
    // Getter method that keeps track of the number of intermediate loot collected
    public int getDiamondCount() {
        return diamondCount;
    }
    // List the number of collected diamonds
    public List<Vec2> getEatenDiamond() {
        return eatenDiamond;
    }


    public void addEatenDiamond(Vec2 diamondPosition) {
        eatenDiamond.add(diamondPosition);
    }


    @Override
    public World getWorld() {
        return world;
    }
}
