package game;


import org.jbox2d.common.Vec2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Enable saving game state.
 */
public class GameSaverLoader {

    /**
     * Saves current game state to a .txt file.
     * <p>
     * Saves current
     *
     * @param  level Current level that the main character is in.
     * @param  fileName File that contains the saved data related to the current game state.
     * @return Nothing.
     */

    public static void save(GameLevel level, String fileName)
            throws IOException
    {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + ";" +
                    level.getRover().getDiamondCount() + ";" +
                    level.getRover().getEyeCount() + ";" +
                    level.getRover().getPosition() + ";" +
                    level.getRover().getEatenDiamond() + ";"
                    + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }



    public static void load(Game game, String fileName)
            throws IOException
    {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
                String[] tokens = line.split(";");
                String name = tokens[0];
                int diamondCount = Integer.parseInt(tokens[1]);
                int eyeCount = Integer.parseInt(tokens[2]);

                String token_3 = tokens[3];
                token_3 = token_3.substring(1);
                token_3 = token_3.substring(0,token_3.length() - 1);
                String[] coords = token_3.split(",");

                String coord = coords[0];
                float x = Float.parseFloat(coords[0]);
                float y = Float.parseFloat(coords[1]);

                String token_4 = tokens[4];
                token_4 = token_4.substring(1,token_4.length() - 1);
                //String[] diamondCoords = token_4.split(",");
                token_4= token_4.replaceAll("[()^]*", "");
                System.out.println(token_4);
               /* String[] diamondCoords= token_4.split(",");
                float[] floatDiamondCoords= new float[diamondCoords.length];
                System.out.println(Arrays.toString(floatDiamondCoords));

                */

            Scanner scanner = new Scanner(token_4);
            List<Float> list = new ArrayList<Float>();
            while (scanner.hasNextFloat()) {
                list.add(scanner.nextFloat());
            }
            System.out.println(list);
                Vec2 position = new Vec2(x, y);
                Level1 levelLoad = new Level1(game, position);

                new Game(levelLoad);

                GameLevel level = null;
                if (name.equals("Level1"))
                    level = new Level1(game);
                else if (name.equals("Level2"))
                    level = new Level2(game);
                else if (name.equals("Level3"))
                    level = new Level3(game);
                else if (name.equals("Level4"))
                    level = new Level4(game);
                else if (name.equals("Level5"))
                    level = new Level5(game);

                level.getRover().setDiamondCount(diamondCount);
                level.getRover().setPosition(position);



                /*
            // Stop level 1
            level.stop();
            // Pass to level 2
            level = new Level2(game);
            game.getRover() = level.getRover();
            // Switch view to the new level
            view.setWorld(level);
            // Switch controls over the rover in the new world
            controls.updateRover(level.getRover());
            // Start the simulation in the new level
            level.start();

               // return level;
*/

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
