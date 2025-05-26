package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/**
 * Extends the game word by implementing multiple game stages (levels).
 */
public class Level3 extends GameLevel {

    // Field to add diamond as loot
    private Diamond diamond;
    // Field to add Ender-Eye as bonus loot
    private EnderEye enderEye;

    // Base class generating the bodies
    public Level3(Game game){
        super(game);

        // Add the Redstone
        getRedstone().setPosition(new Vec2(0,8));
        // Add the Rover
        getRover().setPosition(new Vec2(-10, -10));

        // Add collision listener between rover and diamond
        getRover().addCollisionListener(new DiamondCollection(getRover()));
        // Add collision listener between rover and Ender-Eye
        getRover().addCollisionListener(new EnderEyeCollection(getRover()));

        // Make the ground
        for (int i = 0; i < 3; i++) {
            Shape groundShape = new PolygonShape(
                    -9.49f, 2.0f,
                    9.49f, 2.04f,
                    9.52f, -2.04f,
                    -9.56f, -1.96f);
            StaticBody ground = new StaticBody(this, groundShape);
            ground.addImage(new BodyImage("data/mars_ground1.png", 4f));
            ground.setPosition(new Vec2(-7.5f + i * 11.5f, -12.6f));
        }

        // Add left wall to prevent fall
        Shape wallShapeL = new BoxShape(0.5f, 30f);
        StaticBody leftWall = new StaticBody(this, wallShapeL);
        leftWall.setPosition(new Vec2(-13f, -9));
        // Add right wall to prevent fall
        Shape wallShapeR = new BoxShape(0.5f, 30f);
        StaticBody rightWall = new StaticBody(this, wallShapeR);
        rightWall.setPosition(new Vec2(13f, -9));


        // Make a platform
        Shape platform1Shape = new BoxShape(1f, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(10f, -7f));
        // Make a platform
        Shape platform2Shape = new BoxShape(1f, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-2f, -5f));
        // Make a platform
        Shape platform3Shape = new BoxShape(1f, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(-11.5f, -1.2f));
        // Make a platform
        Shape platform4Shape = new BoxShape(2f, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(1f, 2f));
        // Make a platform
        Shape platform5Shape = new BoxShape(0.5f, 0.5f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-10f, 5f));
        // Make a platform
        Shape platform6Shape = new BoxShape(1f, 0.5f);
        StaticBody platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(0, 7f));


        // Add the loot
        diamond = new Diamond(this);
        diamond.setPosition(new Vec2(10,-6));
        diamond = new Diamond(this);
        diamond.setPosition(new Vec2(-10,6));

        // Add an Ender-Eye (Bonus Loot)
        enderEye = new EnderEye(this);
        enderEye.setPosition(new Vec2(-12f,0));
    }

    // Condition for level completion
    public boolean isComplete() {
        if (getRover().getDiamondCount() == 2)
            return true;
        else
            return false;
    }

    @Override
    public String getLevelName() {
        return "Level3";
    }
}
