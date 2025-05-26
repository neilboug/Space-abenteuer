package game;

import city.cs.engine.*;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



/**
 * Add a randomly generated dynamic body to the game world.
 */
public class Meteor extends DynamicBody {
    private static final Shape meteorShape = new PolygonShape(
            -0.09f, 1.98f,
            1.05f, -1.18f,
            0.21f, -1.9f,
            -0.42f, -1.9f,
            -1.13f, -1.25f
    );
    // Add an image to the meteor's shape
    private static final BodyImage image =
            new BodyImage("data/meteor.gif", 4f);


    public Meteor(World world) {
        super(world,meteorShape);
        addImage(image);
    }

    @Override
    // Destroy object
    public void destroy() {
        super.destroy();
    }
}
