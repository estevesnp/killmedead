package io.codeforall.teamf;

import io.codeforall.teamf.Balls.Ball;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Bullet {

    private Background background;
    private Player player;
    private LinkedList<Ball> balls;
    private Picture picture;
    private final int SPEED = 2;

    public Bullet(int x, int y, Background background, Player player, LinkedList<Ball> balls) {

        this.background = background;
        this.player = player;
        this.balls = balls;

        picture = new Picture(x, y, "gamejam/resources/bullet.png");
        picture.translate(0, -picture.getHeight());
        picture.draw();

    }

    public void move() {
        picture.translate(0, -SPEED);

        for (Ball ball : balls) {
            if (collideWithBall(ball)) {
                balls.remove(ball);
                ball.delete();
                this.delete();
                break;
            }
        }
        if (picture.getY() <= background.getY()) {
            delete();
        }
    }

    public boolean collideWithBall(Ball ball) {

        int bulletHitBoxX = picture.getX() + (picture.getMaxX() - picture.getX())/2;

        if ((ball.getX() <= bulletHitBoxX && bulletHitBoxX <= ball.getMaxX()) && (ball.getY() <= picture.getY() && picture.getY() <= ball.getMaxY())) {
            return true;
        }

        return false;
    }

    public void delete() {
        picture.delete();
        player.setShooting(false);
    }

}
