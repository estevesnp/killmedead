package teamf;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import javax.sound.sampled.AudioSystem;
import java.io.*;
import java.net.URL;
import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class ScoreUpdater implements Iterable<PlayersLeaderboard>{

    public static String filepath = "/Highscore.txt";

    private ArrayList<PlayersLeaderboard> leaderboard;
    private BufferedWriter bWriter;
    private BufferedReader bReader;

    public ScoreUpdater(ArrayList<PlayersLeaderboard> leaderboard) {

        this.leaderboard = leaderboard;


    }

    public void readFromFile(){

        try {
/*
            InputStream inputStream = ClassLoader.getSystemClassLoader().getSystemResourceAsStream(filepath);
            InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
            bReader = new BufferedReader(streamReader);
 */

/*
            FileInputStream fis = new FileInputStream(filepath);
            DataInputStream dis = new DataInputStream(fis);
            bReader = new BufferedReader(new InputStreamReader(this.getResourceAsStream???(filepath)));
 */

            InputStream is = getClass().getResourceAsStream(filepath);
            bReader = new BufferedReader(new InputStreamReader(is));

             //bReader = new BufferedReader(new FileReader(filepath));

            String line;
            String[] splitLine;
            while ((line = bReader.readLine()) != null) {
                splitLine = line.split(":");
                leaderboard.add(new PlayersLeaderboard(splitLine[0], Integer.valueOf(splitLine[1])));
            }
            bReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
/*
    public void saveToFile() {
        try {

            //InputStream is = getClass().getResourceAsStream(filepath);
           // bReader = new BufferedReader(new InputStreamReader(is));




            System.out.println(leaderboard.size());
            bWriter = new BufferedWriter(new FileWriter(filepath));

            //for (PlayersLeaderboard b : leaderboard) {
            for (int i = 0; i < 5; i++){
               // bWriter.write(b.getName() + ":" + b.getScore() + "\n");
                bWriter.write("sim se:4" + "\n");
            }
            readFromFile();
            bWriter.close();
        }catch (Exception e) {}
    }


 */
    public void displayScores(int x, int y, int size, Text[] texts){

        Collections.sort(leaderboard);

        texts[0] = new Text(x, y, "Highscores:", "Dialog", 0, size);
        texts[0].setColor(Color.WHITE);
        texts[0].draw();

        for (int i = 1; i < texts.length; i++) {
            texts[i] = new Text(x, y + (i * size),leaderboard.get(i - 1).getName() + ": " + leaderboard.get(i - 1).getScore(),"Dialog", 0, size);
            texts[i].setColor(Color.WHITE);
            texts[i].draw();
        }
    }

    @Override
    public Iterator<PlayersLeaderboard> iterator() {
        return leaderboard.iterator();
    }
}
