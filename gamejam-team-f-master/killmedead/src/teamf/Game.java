package teamf;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private Menu menu;
    private Background background;
    private Player player;
    private ArrayList<Ball> balls = new ArrayList<>();
    private boolean gameOver = false;
    private int gamesPlayed = 0;
    private int level = 1;
    public static int score = 0;
    private String startMenu = "startManu.jpg";
    private String loseMenu = "loseMenu.png";
    private String victoryMenu = "winMenu.png";
    private String menuPath = startMenu;
    private ArrayList<PlayersLeaderboard> leaderboard = new ArrayList<>();
    private ScoreUpdater scoreUpdater;
    private Text scoreBoard;
    private MenuType menuType = MenuType.START;
    private Sound themeMusic = new Sound();
    private Sound pressStart = new Sound();

    private Sound loseGame = new Sound();

    private Sound winGame = new Sound();
    public static char currChar;
    private Text[] texts = new Text[6];
    private Text[] insertScoreText = new Text[6];

    public Game() {
        Rectangle rectangle = new Rectangle(10, 10, 1845, 822);
        rectangle.fill();
        scoreUpdater = new ScoreUpdater(leaderboard);
        scoreUpdater.readFromFile();
        menu = new Menu();
        menu.init();


    }

    public void startMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        Text playerScore = new Text(0,0,"");

        menu.setPicture(menuPath);
        menu.show();


        switch (menuType) {
            case START:
                break;

            case LOSE:

                playerScore = new Text(background.getMaxX() - 500, 50, "YOUR SCORE: " + score, "Dialog", 0, 50);
                playerScore.setColor(Color.WHITE);
                playerScore.draw();

                scoreUpdater.displayScores(40,40, 50, texts);

                if (score > leaderboard.get(4).getScore()) {
                    setNewScore();
                }

                level = 1;
                score = 0;
                break;

            default: // WIN
                level++;
                score += 100;
                break;
        }

        menu.setGameStarted(false);

        while(!menu.gameStarted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){}
        }

        for (Text text : texts) {
            if (text != null) {
                text.delete();
            }
        }

        for (Text text : insertScoreText) {
            if (text != null) {
                text.delete();
            }
        }

        playerScore.delete();

        menu.delete();

        pressStart.playSound("/audio/pressStart.wav");
        themeMusic.playSound("/audio/gameTheme.wav");
        themeMusic.getClip().loop(Clip.LOOP_CONTINUOUSLY);
    }


    public void init() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        background = new Background();
        background.show();

        scoreBoard = new Text(background.getX() + 53, 25, "<SCORE : " + score + "_>", "Dialog", 0, 33);
        scoreBoard.setColor(new Color(68, 92, 82));


        LevelGenerator.generateLevel(level, balls, background);

        player = new Player(background, balls);

    }

    public void start() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

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

        themeMusic.getClip().stop();
        themeMusic.getClip().close();
    }


    private void setNewScore() {
        String newPlayerName = "";

        boolean canAdvance;

        insertScoreText[4] = new Text(background.getX() + background.getWidth()/2 - 200,background.getY() + background.getHeight()/2 - 175, "Insert Name", "Dialog", 0, 50 );
        insertScoreText[4].setColor(Color.WHITE);
        insertScoreText[4].draw();


        for (int i = 0; i < 4; i++) {

            currChar = 65;

            insertScoreText[i] = new Text(background.getX() + background.getWidth()/2 - 200 + i * 50, background.getY() + background.getHeight()/2 - 100, String.valueOf(currChar), "Dialog", 0, 50);
            insertScoreText[i].setColor(Color.WHITE);
            insertScoreText[i].draw();

            menu.setCanAdvance(false);

            while(!menu.canAdvance()) {

                insertScoreText[i].setText(String.valueOf(currChar));

            }

            newPlayerName += currChar;

        }

        insertScoreText[5] = new Text(background.getX() + background.getWidth()/2 - 200,background.getY() + background.getHeight()/2 - 25, "Score Saved Successfully!", "Dialog", 0, 50 );
        insertScoreText[5].setColor(Color.MAGENTA);
        insertScoreText[5].draw();

        leaderboard.add(new PlayersLeaderboard(newPlayerName, score));
        Collections.sort(leaderboard);
        leaderboard.remove(leaderboard.size()-1);

    }



    private void updateScore() {
        scoreBoard.setText("<SCORE : " + score + "_>");
    }


    private void checkGameOver() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
//////////////////////////////////////////////////////////////////////////////
        // Lose Game
        if (!player.isAlive()) {
            loseGame.playSound("/audio/gameOver.wav");
            gameOver = true;
            menuPath = loseMenu;
            menuType = MenuType.LOSE;

        }

        // Win Game
        if (balls.isEmpty()) {
            winGame.playSound("/audio/win.wav");
            gameOver = true;
            menuPath = victoryMenu;
            menuType = MenuType.VICTORY;


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
