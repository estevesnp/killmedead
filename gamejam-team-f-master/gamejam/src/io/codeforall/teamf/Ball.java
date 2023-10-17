package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball {

    private Background background;
    private Picture ball;
    private double hSpeed = 0.5;
    private double vSpeed = 0.5;


    public Ball(Background background) {
        ball = new Picture(0, 10, "gamejam/resources/ball.png");
        ball.draw();
        this.background = background;
    }

    public void moveBall() {

        this.ball.translate(hSpeed, vSpeed);

        if (ball.getX() < background.getX() || ball.getMaxX() > background.getMaxX()) {
            hSpeed = -hSpeed;
        }

        if (ball.getY() < background.getY() || ball.getMaxY() > background.getMaxY()) {
            vSpeed = -vSpeed;
        }


    }


}