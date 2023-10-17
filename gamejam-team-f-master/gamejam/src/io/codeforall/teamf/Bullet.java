package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet {

    private Picture picture;
    private Player player;
    private Background background;
    private final int SPEED = 2;

    public Bullet(int x, int y, Player player, Background background) {
        picture = new Picture(x, y, "gamejam/resources/bullet.png");
        picture.translate(0, -picture.getHeight());
        picture.draw();

        this.player = player;
        this.background = background;
    }

    public void move() {
        picture.translate(0, -SPEED);
        if (picture.getY() <= background.getY()) {
            delete();
        }
    }


    public void delete() {
        picture.delete();
        player.setShooting(false);
    }




}
