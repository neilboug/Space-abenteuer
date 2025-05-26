package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;



/**
 * Implement a collision listener to remove the generated dynamic body from the game world upon collision with the main character.
 */
public class MeteorCollection implements CollisionListener {

    private Rover rover;

    public MeteorCollection(Rover r) {

        this.rover = r;

    }

    // Add sound effect
    private static SoundClip damageSound;
    static {
        try {
            damageSound = new SoundClip("data/tracks/damage.wav");
            System.out.println("Loading item sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Print error if the track is missing
            System.out.println(e);
        }
    }

    @Override
    public void collide(CollisionEvent d) {
        if (d.getOtherBody() instanceof Meteor) {
            rover.subLife();
            damageSound.play();
            d.getOtherBody().destroy();
        }
    }
}
