package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;



/**
 * Add a bonus loot to the game as a dynamic body.
 */
public class EnderEye extends DynamicBody {
    private static final Shape eyeShape = new CircleShape(1);

    // Add sound effect
    private static SoundClip itemSound;
    static {
        try {
            itemSound = new SoundClip("data/tracks/collect_endereye.wav");
            System.out.println("Loading item sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Print error if the track is missing
            System.out.println(e);
        }
    }

    // Add an image to the Ender-Eye's shape
    private static final BodyImage image =
            new BodyImage("data/ender_eye.png", 1.5f);

    // Add Ender-Eye to the world
    public EnderEye(World world) {
        super(world,eyeShape);
        addImage(image);
    }

    @Override
    // Destroy object and play sound effect
    public void destroy() {
        itemSound.play();
        super.destroy();
    }
}
