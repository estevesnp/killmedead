package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {

    private Background background;
    private Picture picture;
    private double hSpeed;
    private double vSpeed;


    public Ball(Background background, double speed) {
        this.background = background;
        picture = new Picture(background.getX(), background.getY(), "gamejam/resources/ball.png");
        picture.draw();
        setRandomX();
        hSpeed = speed;
        vSpeed = speed;
    }

    private void setRandomX() {
        picture.translate(Math.random() * (background.getMaxX() - picture.getWidth()), 0);
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