package game;

import javax.swing.*;
import java.io.IOException;



/**
 * Implement a graphical interface to the game by adding buttons.
 */
public class ControlPanel {
    private JPanel mainPanel;
    private JButton resumeButton;
    private JButton pauseButton;

    private JButton saveQuitButton;
    private JButton loadButton;

    private Game level;

    public ControlPanel(Game level) {
        this.level = level;

        // Enable pause button function
        pauseButton.addActionListener(e -> level.pause());

        // Enable resume button function
        resumeButton.addActionListener(e -> level.resume());

        // Enable save current score and position then quit
        saveQuitButton.addActionListener(e -> {
            try {
                GameSaverLoader.save(level.getLevel(), "data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.exit(0);
        });

        loadButton.addActionListener(e -> {
            try {
                GameSaverLoader.load(level, "data/save.txt");
                level.setLevel(level.getLevel());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }


    // Control panel accessor
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
