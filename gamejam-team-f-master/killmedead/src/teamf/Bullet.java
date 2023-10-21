package teamf;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

public class Bullet {

    private Background background;
    private Player player;
    private ArrayList<Ball> balls;
    private Picture picture;
    private final int SPEED = 2;

    private Sound bullet = new Sound();
    private Sound bubbleBurst = new Sound();

    public Bullet(int x, int y, Background background, Player player, ArrayList<Ball> balls) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        this.background = background;
        this.player = player;
        this.balls = balls;

        picture = new Picture(x, y, "Bell.png");
        picture.translate(0, -picture.getHeight());
        picture.draw();
//////////////////////////////////////////////////////////////////////////
        bullet.playSound("/audio/bellDing.wav");

    }

    public void move() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        picture.translate(0, -SPEED);

        for (Ball ball : balls) {
            if (collideWithBall(ball)) {
                if (ball.getBallType().getNextBall() != null) {
                    balls.add(new Ball(background, ball.getBallType().getNextBall(), ball.getX(), ball.getY(), true, false));
                    balls.add(new Ball(background, ball.getBallType().getNextBall(), ball.getX(), ball.getY(), false, false));
                }
                balls.remove(ball);
                ball.delete();
                this.delete();
                break;
            }
        }
        if (picture.getY() <= background.getY()) {
            Game.score -= 5;
            delete();
        }
    }

    public boolean collideWithBall(Ball ball) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        int bulletHitBoxX = picture.getX() + (picture.getMaxX() - picture.getX())/2;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////7
        if ((ball.getX() <= bulletHitBoxX && bulletHitBoxX <= ball.getMaxX()) && (ball.getY() <= picture.getY() && picture.getY() <= ball.getMaxY())) {
            bubbleBurst.playSound("/audio/bubbleBurst.wav");
            Game.score += 20;
            return true;
        }

        return false;
    }

    public void delete() {
        picture.delete();
        player.setShooting(false);
    }

}
