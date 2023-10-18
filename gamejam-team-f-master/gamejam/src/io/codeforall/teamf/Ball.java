package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {

    private Background background;
    private Picture picture;
    private double hSpeed = 0.5;
    private double vSpeed = 0.5;


    public Ball(Background background) {
        this.background = background;
        picture = new Picture(0, 0, "gamejam/resources/ball.png");
        picture.draw();
    }

    public void move() {

        this.picture.translate(hSpeed, vSpeed);

        if (picture.getX() < background.getX() || picture.getMaxX() > background.getMaxX()) {
            hSpeed = -hSpeed;
        }

        if (picture.getY() < background.getY() || picture.getMaxY() > background.getMaxY()) {
            vSpeed = -vSpeed;
        }

    }

    public void delete() {
        picture.delete();
    }

    public int getX() {
        return picture.getX();
    }

    public int getMaxX() {
        return picture.getMaxX();
    }

    public int getY() {
        return picture.getY();
    }

    public int getMaxY() {
        return picture.getMaxY();
    }

}