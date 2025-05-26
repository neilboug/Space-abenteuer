package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.util.Random;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Extends the game word by implementing multiple game stages (levels).
 */
public class Level5 extends GameLevel implements ActionListener {

    private Random rand;

    // Base class generating the bodies
    public Level5(Game game){
        super(game);

        // Add the redstone
        getRedstone().setPosition(new Vec2(-10,11));
        // Add the Rover
        getRover().setPosition(new Vec2(2, -10));

        // Add collision listener between rover and diamond
        getRover().addCollisionListener(new DiamondCollection(getRover()));
        // Add collision listener between rover and meteors
        getRover().addCollisionListener(new MeteorCollection(getRover()));


        // Make the ground
        for (int i = 0; i < 3; i++) {
            Shape groundShape = new PolygonShape(
                    -12.72f ,1.9f,
                    12.87f, 1.9f,
                    12.87f, -2.05f,
                    -12.77f, -2.05f
            );
            StaticBody ground = new StaticBody(this, groundShape);
            ground.addImage(new BodyImage("data/venus_ground1.png", 4f));
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


        /*
        // Make a platform
        Shape platform1Shape = new BoxShape(0.5f, 1.7f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-11.5f, -9.5f));

        // Make a platform
        Shape platform2Shape = new BoxShape(1f, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-2f, -3.5f));

        // Make a platform
        Shape platform3Shape = new BoxShape(2.5f, 0.5f, new Vec2(0f,0f), 20);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(5f, -1.2f));

        // Make a platform
        Shape platform4Shape = new BoxShape(0.5f, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(12f, 5f));

        // Make a platform
        Shape platform5Shape = new BoxShape(0.5f, 1.4f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-10f, 9.2f));

        // Make a platform
        Shape platform6Shape = new BoxShape(2.5f, 0.5f, new Vec2(0f,0f), 40);
        StaticBody platform6 = new StaticBody(this, platform6Shape);
        platform6.setPosition(new Vec2(-11.8f, 10f));

        Shape platform7Shape = new BoxShape(1f, 0.5f);
        StaticBody platform7 = new StaticBody(this, platform7Shape);
        platform7.setPosition(new Vec2(-4f, 3f));
        */


        /*
        // Add the loot
        diamond = new Diamond(this);
        diamond.setPosition(new Vec2(-12,-7));

        diamond = new Diamond(this);
        diamond.setPosition(new Vec2(-4,4));

        diamond = new Diamond(this);
        diamond.setPosition(new Vec2(12,6));
         */

        // Timer to implement delayed pick-ups
        Timer t = new Timer(4000, this);
        t.start();
        rand = new Random();
    }



    // Condition for level completion
    public boolean isComplete() {
        if (getRover().getDiamondCount() == 1)
            return true;
        else
            return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Meteor m1 = new Meteor(this);
    Meteor m2 = new Meteor(this);
    m1.setPosition(new Vec2(rand.nextFloat() * 12, 30));
    m2.setPosition(new Vec2(rand.nextFloat() * -12, 60));
    }

    @Override
    public String getLevelName() {
        return "Level1";
    }
}
