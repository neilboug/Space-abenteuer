package game;

import city.cs.engine.*;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



/**
 * Add an intermediate loot to the game as a dynamic body.
 */
public class Diamond extends DynamicBody {
    private static final Shape diamondShape = new PolygonShape(
            0.181f, 0.753f,
            0.7f, -0.111f,
            0.418f, -0.747f,
            -0.419f, -0.744f,
            -0.692f, -0.042f,
            -0.224f, 0.747f
    );

    // Add sound effect
    private static SoundClip itemSound;
    static {
        try {
            itemSound = new SoundClip("data/tracks/collect_item.wav");
            System.out.println("Loading item sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Print error if the track is missing
            System.out.println(e);
        }
    }

    // Add an image to the diamond's shape
    private static final BodyImage image =
            new BodyImage("data/diamond.png", 1.5f);

    public Diamond(World world) {
        super(world,diamondShape);
        addImage(image);
    }

    @Override
    // Destroy object and play sound effect
    public void destroy() {
        itemSound.play();
        super.destroy();
    }
}
