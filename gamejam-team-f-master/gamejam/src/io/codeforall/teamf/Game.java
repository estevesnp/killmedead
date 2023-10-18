package io.codeforall.teamf;

public class Game {

    private Background background;
    private Player player;
    private Ball ball;


    public Game() {
    }

    public void init() {
        background = new Background();
        background.show();
        ball = new Ball(background);
        player = new Player(background, ball);
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
        ball.move();

    }



}
