package game;

import javax.swing.*;
import java.awt.*;

import city.cs.engine.World;
import city.cs.engine.UserView;



/**
 * Implement a game interface that displays game related information.
 */
public class GameView extends UserView {
    private Game game;
    private Image background;

    private Image heartIcon;
    private Image meteorIcon;
    private Image diamondIcon;
    private Image endereyeIcon;

    public GameView(World w, int width, int height) {
        super(w, width, height);

        // Background image
        background = new ImageIcon("data/background.gif").getImage();

        // Heart icon to keep track of lives left
        heartIcon = new ImageIcon("data/heart_icon.png").getImage();
        // Meteor icon to track of destroyed meteors
        meteorIcon = new ImageIcon("data/meteor_icon.png").getImage();
        // Diamond icon to keep track of pending score
        diamondIcon = new ImageIcon("data/diamond_icon.png").getImage();
        // Ender Eye icon to track of bonus loot
        endereyeIcon = new ImageIcon("data/ender_eye_icon.png").getImage();
    }


    @Override
    // Add background image to game view
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);
    }


    @Override
    // Add graphical interface to game view
    protected void paintForeground(Graphics2D g) {

        // Keeps track of life count
        g.drawImage(heartIcon,239,5, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        g.drawString(game.getRover().getLifeCount() + "",219,28);

        // Keep track of destroyed Meteors
        g.drawImage(meteorIcon,25,70, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.drawString(game.getRover().getMeteorCount() + "",8,95);

        // Keeps track of collected diamond
        g.drawImage(diamondIcon,25,5, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.drawString(game.getRover().getDiamondCount() + "",8,25);

        // Keeps track of collect Ender-Eyes (Bonus loot)
        g.drawImage(endereyeIcon,25,40, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        g.drawString(game.getRover().getEyeCount() + "",8,60);
    }


    public void setGame(Game game) {
        this.game = game;
    }
}
