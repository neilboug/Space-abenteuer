package game;


import java.io.IOException;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Implement a keyboard listener that enables keyboard control over the main character.
 */
public class RoverControls implements KeyListener {
    // Field to give access for the rover
    private Rover rover;
    // Set the displacement speed for the Rover
    private static final float SPEED = 9;
    private Game game;


    public RoverControls(Rover r){
        rover = r;
    }


    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    // Implement keyboard key typing
    public void keyTyped(KeyEvent e) {
    }

    @Override
    // Other key commands omitted
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
          // Press Q to go left
        if (code == KeyEvent.VK_Q) {
            rover.startWalking(-SPEED);

        } // Press D to go left
        else if (code == KeyEvent.VK_D) {
            rover.startWalking(SPEED);

        } // Press Space bar to jump!
        else if (code == KeyEvent.VK_SPACE) {
            rover.jump(9);

        } // Press F to shoot a laser
        else if (code == KeyEvent.VK_F) {
            Laser l = new Laser(this.rover.getWorld(),
                    this.rover.getPosition().add(new Vec2(0,1)),
                    60);

         } // Press S to save current level
        /* else if (code == KeyEvent.VK_S) {
            try {
                GameSaverLoader.save(game.getLevel(), "data/save.txt");
            } catch (IOException ioException){
                ioException.printStackTrace();
            }
        } // Press L to load previous game session
        else if (code ==KeyEvent.VK_L) {
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        */
    }


    @Override
    // Prevent continual displacement
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) {
            rover.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            rover.stopWalking();
        }
    }

    public void updateRover(Rover rover){
        this.rover = rover;
    }

}
