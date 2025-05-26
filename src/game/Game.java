package game;

import java.awt.*;
import javax.swing.*;

import java.io.IOException;

import javax.sound.sampled.*;
import city.cs.engine.SoundClip;

import city.cs.engine.DebugViewer;



/**
 * Initialise a new game world with some bodies.
 */
public class Game {

    /**
     * Initialise a new game world with some bodies.
     * <p>
     * Creates a new game simulation that contains different bodies that interacts with each others.
     *
     * @param  level Current level that the main character is in.
     * @return Nothing.
     */

    // Field to give access to the rover */
    private Rover rover;

    /** A graphical display of the world. */
    private GameView view;

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    // Field to add keys controls
    private RoverControls controls;

    // Field to implement a background soundtrack */
    private SoundClip levelUpSoundtrack;

    // Field to implement a background soundtrack */
    private SoundClip backgroundSoundtrack;


    /** Initialise a new Game. (constructor)*/
    public Game() {

        // Initialize level to Level1
        this.level = new Level1(this);
        this.rover = this.level.getRover();

        // Make a background soundtrack
        try {
            // Loads the audio input
            backgroundSoundtrack = new SoundClip("data/tracks/background_soundtrack.wav");
            backgroundSoundtrack.loop();    // Loop the track continuously
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            // Print error if the track is missing
            System.out.println(e);
        }


        // Make a view
        view = new GameView(level, 498, 563);
        view.setGame(this);
        view.setZoom(20);

        //* uncomment to draw a 1 meter grid over the view *//
        //view.setGridResolution(1);

        // Add some keyboard action
        controls = new RoverControls(level.getRover());
        view.addKeyListener(controls);
        RoverControls controls = new RoverControls(level.getRover());
        view.addKeyListener(controls);

        // Add mouse action
        view.addMouseListener(new GiveFocus(view));


        // Add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Space Abenteuer");
        frame.add(view);
        // Enable x button frame to quit the application when pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // Don't let the frame be resized
        frame.setResizable(false);

        // Implement GUI
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.SOUTH);

        // Size the frame to fit the world view
        frame.pack();
        // Make the frame visible
        frame.setVisible(true);


        //* uncomment this to make a debugging view *//
        //JFrame debugView = new DebugViewer(level, 498, 563);

        // Start game world simulation
        level.start();
    }


    /** Initialise a new Game. */
    public Game(GameLevel level) {

        // Initialize level to Level1
        this.level = level;
        this.rover = this.level.getRover();

        /*
        // Make a background soundtrack
        try {
            // Loads the audio input
            backgroundSoundtrack = new SoundClip("data/tracks/background_soundtrack.wav");
            backgroundSoundtrack.loop();    // Loop the track continuously
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            // Print error if the track is missing
            System.out.println(e);
        } */


        // Make a view
        view = new GameView(level, 498, 563);
        view.setGame(this);
        view.setZoom(20);
        //* uncomment to draw a 1 meter grid over the view *//
        //view.setGridResolution(1);
        // Add some keyboard action
        controls = new RoverControls(level.getRover());
        view.addKeyListener(controls);
        RoverControls controls = new RoverControls(level.getRover());
        view.addKeyListener(controls);

        // Add mouse action
        view.addMouseListener(new GiveFocus(view));


        // Add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Space Abenteuer");
        frame.add(view);
        // Enable x button frame to quit the application when pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // Don't let the frame be resized
        frame.setResizable(false);

        // Implement GUI
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.SOUTH);

        // Size the frame to fit the world view
        frame.pack();
        // Make the frame visible
        frame.setVisible(true);


        //* uncomment this to make a debugging view *//
        //JFrame debugView = new DebugViewer(level, 498, 563);

        // Start game world simulation
        level.start();
    }

    // Getter method to give access to Rover
    public Rover getRover() {
        return this.rover;
    }

    public void setLevel(GameLevel level) {
        // Stops current level
        this.level.stop();
        // Refers to the new level
        this.level = level;
        // Switch view to the new level
        view.setWorld(level);
        // Start the simulation in the new level
        this.level.start();
    }

    // Getter method to give access to level
    public GameLevel getLevel() {
        return this.level;
    }


    // Method to pass from through levels
    public void goToNextLevel(){

        if (level instanceof Level1){
            // Stop level 1
            level.stop();
            // Pass to level 2
            level = new Level2(this);
            this.rover = level.getRover();
            // Switch view to the new level
            view.setWorld(level);
            // Switch controls over the rover in the new world
            controls.updateRover(level.getRover());
            // Start the simulation in the new level
            level.start();
            //* uncomment this to make a debugging view *//
            //Frame debugView = new DebugViewer(level, 498, 563);
            // Make a transition soundtrack
            try {
                // Loads the audio input
                levelUpSoundtrack = new SoundClip("data/tracks/stage_up.wav");
                levelUpSoundtrack.play();    // Play the track to mark transition
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                // Print error if the track is missing
                System.out.println(e);
            }
        }
        else if (level instanceof Level2) {
            // Stop level 2
            level.stop();
            // Pass to level 3
            level = new Level3(this);
            this.rover = level.getRover();
            view.setWorld(level);
            controls.updateRover(level.getRover());
            level.start();
            //* uncomment this to make a debugging view *//
            //JFrame debugView = new DebugViewer(level, 498, 563);
            // Make a transition soundtrack
            try {
                // Loads the audio input
                levelUpSoundtrack = new SoundClip("data/tracks/stage_up.wav");
                levelUpSoundtrack.play();    // Play the track to mark transition
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                // Print error if the track is missing
                System.out.println(e);
            }
        }
        else if (level instanceof Level3) {
            // Stop level 3
            level.stop();
            // Pass to level 4
            level = new Level4(this);
            this.rover = level.getRover();
            view.setWorld(level);
            controls.updateRover(level.getRover());
            level.start();
            //* uncomment this to make a debugging view *//
            //JFrame debugView = new DebugViewer(level, 498, 563);
            // Make a transition soundtrack
            try {
                // Loads the audio input
                levelUpSoundtrack = new SoundClip("data/tracks/stage_up.wav");
                levelUpSoundtrack.play();    // Play the track to mark transition
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                // Print error if the track is missing
                System.out.println(e);
            }
        }
        else if (level instanceof Level4) {
            // Stop level 4
            level.stop();
            // Pass to level 5
            level = new Level3(this);
            this.rover = level.getRover();
            view.setWorld(level);
            controls.updateRover(level.getRover());
            level.start();
            //* uncomment this to make a debugging view *//
            //JFrame debugView = new DebugViewer(level, 498, 563);
            // Make a transition soundtrack
            try {
                // Loads the audio input
                levelUpSoundtrack = new SoundClip("data/tracks/stage_up.wav");
                levelUpSoundtrack.play();    // Play the track to mark transition
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                // Print error if the track is missing
                System.out.println(e);
            }
        }
        else if (level instanceof Level5){
            System.out.println("You have completed all game stages!");
            System.exit(0);
        }
    }

    /** To pause the game */
    public void pause() {
        level.stop();
    }
    /** To resume the game */
    public void resume() {
        level.start();
    }



    /**
     * Run the game.
     */
    public static void main(String[] args) {

        new Game();
    }
}
