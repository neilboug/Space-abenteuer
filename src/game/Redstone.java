package game;

import city.cs.engine.*;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



/**
 * Add a dynamic body that enables transition between levels.
 */
public class Redstone extends Walker {
    private static final Shape redstoneShape = new PolygonShape(
            -0.003f, 0.747f,
            0.815f, -0.147f,
            0.272f, -0.74f,
            -0.272f, -0.743f,
            -0.812f, -0.124f
    );


    // Add an image to the Redstone's shape
    private static final BodyImage image =
            new BodyImage("data/redstone.png", 1.5f);

    // Add the Redstone to the world
    public Redstone(World world) {
        super(world ,redstoneShape);
        addImage(image);
    }

    @Override
    // Destroy object
    public void destroy() {
        super.destroy();
    }
}
