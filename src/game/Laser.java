package game;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * Implement an action listener that generates a dynamic body.
 */
public class Laser implements ActionListener {

    private Walker laser;
    private DynamicBody explosion;

    private static SoundClip laserSound;
    private static SoundClip explosionSound;


    static {
        try {
            // Add sound effect for laser shot
            laserSound = new SoundClip("data/tracks/laser.wav");
            // Add sound effect for exploding laser
            explosionSound = new SoundClip("data/tracks/explosion.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private int timerCount;

    // Add laser to the world
    public Laser(World world, Vec2 pos, int time) {

        laser = new Walker(world,
                new PolygonShape(0.002f, 0.488f,
                        0.136f, 0.414f,
                        0.136f, -0.41f,
                        -0.002f, -0.498f,
                        -0.136f, -0.406f,
                        -0.136f ,0.41f));
        laser.addImage(new BodyImage("data/laser.png", 1f));
        laser.setPosition(pos);
        laser.jump(200);

        // Timer that schedules the removal of the laser
        Timer t = new Timer(time, this);
        t.start();
        t.setRepeats(false);


        timerCount = 0;

        // Play the action related sound
        laserSound.play();
    }


    @Override
    //
    public void actionPerformed(ActionEvent e) {

        timerCount ++;

        if (timerCount == 1) {
            // Destroys the laser
            laser.destroy();
            // Stop the action related sound from playing
            laserSound.stop();

            // Add explosion to replace the laser shot
            explosion = new DynamicBody(laser.getWorld(), new CircleShape(2));
            explosion.addImage(new BodyImage("data/explosion.png", 4f));
            explosion.setPosition(laser.getPosition());
            explosionSound.play();

            // Add delay to remove the explosion from the world
            Timer t = new Timer(500, this);
            t.setRepeats(false);
            t.start();

            // Implement collision listening
            explosion.addCollisionListener(new CollisionListener() {
                @Override
                public void collide(CollisionEvent collisionEvent) {
                    // Destroys only only dynamic bodies
                   if(collisionEvent.getOtherBody() instanceof DynamicBody)
                       collisionEvent.getOtherBody().destroy();
                }
            });
        }

        if (timerCount == 2) {
            // Removes the explosion from the world
            explosion.destroy();
            explosionSound.stop();
        }
    }
}
