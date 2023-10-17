package io.codeforall.teamf;

public class Game {

    private Background background;
    private Player player;


    public Game() {
    }

    public void init() {
        background = new Background();
        background.show();
        player = new Player(background);
    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(1);

                player.getBullet().move();

        }



    }



}
