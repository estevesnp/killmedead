package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    Picture picture = new Picture(0,0, "resources/mario.png");
    private int speed = 10;

    public Player() {
        picture.draw();
    }

    public void moveRight() {
        picture.translate(speed, 0);
    }

    public void moveLeft() {
        picture.translate(-speed, 0);
    }

}
