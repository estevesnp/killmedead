package io.codeforall.teamf;

import io.codeforall.teamf.Balls.Ball;
import io.codeforall.teamf.Balls.BallType;

import java.util.LinkedList;

public class Game {

    private Background background;
    private Player player;
    private LinkedList<Ball> balls = new LinkedList<>();


    public Game() {

    }

    public void init() {
        background = new Background();
        background.show();

        balls.add(new Ball(background, BallType.BIG));
        balls.add(new Ball(background, BallType.BIG));
        
        player = new Player(background, balls);
    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(1);

            updateMovement();


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
