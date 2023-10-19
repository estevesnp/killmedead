package io.codeforall.teamf;

import io.codeforall.teamf.Balls.Ball;
import io.codeforall.teamf.Balls.BallType;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {

    private Menu menu;
    private Background background;
    private Player player;
    private ArrayList<Ball> balls = new ArrayList<>();
    private boolean gameOver = false;
    private int gamesPlayed = 0;


    public Game() {

    }

    public void startMenu() {
        System.out.println("Games Played: " + gamesPlayed);

        menu = new Menu();
        menu.show();

        while(!menu.gameStarted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){}
        }

        menu.delete();
    }


    public void init() {

        background = new Background();
        background.show();

        balls.add(new Ball(background, BallType.BIG));
        balls.add(new Ball(background, BallType.BIG));

        player = new Player(background, balls);
    }

    public void start() throws InterruptedException {


        gameOver = false;

        try{
            Thread.sleep(1000);
        } catch (Exception ex) {}


        while (!gameOver) {

            Thread.sleep(1);

            updateMovement();
            checkGameOver();
        }

        background.delete();
        player.delete();
        for (Ball ball : balls) {
            ball.delete();
        }
        balls.clear();

        gamesPlayed++;

    }

    private void checkGameOver() {

        if (!player.isAlive()) {
            gameOver = true;
        }

        if (balls.isEmpty()) {
            gameOver = true;
        }
    }

    private void updateMovement() {
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
