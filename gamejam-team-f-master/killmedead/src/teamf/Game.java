package teamf;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Game {

    private Menu menu;
    private Background background;
    private Player player;
    private ArrayList<Ball> balls = new ArrayList<>();
    private boolean gameOver = false;
    private int gamesPlayed = 0;
    private int level = 1;
    public static int score = 0;
    private String startMenu = "startMenu.png";
    private String loseMenu = "loseMenu.png";
    private String victoryMenu = "victoryMenu.png";
    private String menuPath = startMenu;

    private Text scoreBoard;
    private Sound themeMusic = new Sound();
    private Sound pressStart = new Sound();

    private Sound loseGame = new Sound();

    public Game() throws LineUnavailableException {
    }

    public void startMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        menu = new Menu(menuPath);
        menu.show();

        while(!menu.gameStarted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){}
        }

        menu.delete();

        /////////////////////////////////////////////////////////////////////

        pressStart.playSound("/audio/pressStart.wav");
        themeMusic.playSound("/audio/gameTheme.wav");
        themeMusic.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


    public void init() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        background = new Background();
        background.show();

        scoreBoard = new Text(background.getX() + background.getWidth()/2 - 40, 50, "Score : " + score, "SansSerif", 0, 50);
        scoreBoard.setColor(Color.WHITE);

        LevelGenerator.generateLevel(level, balls, background);

        player = new Player(background, balls);

    }

    public void start() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {


        // loseGame.clip.close();
        // pressStart.clip.close();

        gameOver = false;

        scoreBoard.draw();

        Thread.sleep(1000);

        while (!gameOver) {

            Thread.sleep(1);

            updateMovement();
            updateScore();
            checkGameOver();

        }

        background.delete();
        player.delete();
        scoreBoard.delete();

        for (Ball ball : balls) {
            ball.delete();
        }

        balls.clear();

        gamesPlayed++;

        themeMusic.clip.stop();
        themeMusic.clip.close();

    }

    private void updateScore() {
        scoreBoard.setText("Score : " + score);
    }

    private void checkGameOver() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
//////////////////////////////////////////////////////////////////////////////
        // Lose Game
        if (!player.isAlive()) {
            loseGame.playSound("/audio/gameOver.wav");
            gameOver = true;
            menuPath = loseMenu;
            level = 1;
            score = 0;
        }

        // Win Game
        if (balls.isEmpty()) {
            gameOver = true;
            menuPath = victoryMenu;
            level++;
            score += 100;
        }
    }

    private void updateMovement() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        player.move();
        if (player.isShooting()) {
            player.getBullet().move();
        }
        moveBalls();

    }

    private void moveBalls() {
        for (Ball ball : balls) {
            ball.move();
        }
    }

}
