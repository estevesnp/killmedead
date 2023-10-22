package teamf;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

public class Player implements KeyboardHandler {

    private Background background;
    private ArrayList<Ball> balls;
    private Bullet bullet;
    private String picRight = "player _right.png";
    private String picLeft = "player _left.png";

    private boolean isAlive = true;
    private boolean lookingRight = true;
    private boolean isMoving = false;
    private boolean isShooting = false;
    private boolean spaceIsHeld = false;
    private Picture picture;
    private double speed = 0.8;


    public Player(Background background, ArrayList<Ball> balls) {

        this.background = background;
        this.balls = balls;
        init();
    }

    private void init() {
        picture = new Picture(background.getX() + (background.getMaxX() - background.getX())/2, background.getMaxY(), picRight);
        picture.translate(0, -picture.getHeight());
        picture.draw();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent releasedRight = new KeyboardEvent();
        releasedRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent releasedLeft = new KeyboardEvent();
        releasedLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedLeft.setKey(KeyboardEvent.KEY_LEFT);


        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent releasedSpace = new KeyboardEvent();
        releasedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedSpace.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(pressedRight);
        keyboard.addEventListener(releasedRight);
        keyboard.addEventListener(pressedLeft);
        keyboard.addEventListener(releasedLeft);
        keyboard.addEventListener(pressedSpace);
        keyboard.addEventListener(releasedSpace);

    }

    private void moveRight() {

        if (picture.getMaxX() != background.getMaxX()){
            if (picture.getMaxX() + speed > background.getMaxX()) {
                picture.translate(background.getMaxX() - picture.getMaxX(), 0);
            } else {
                picture.translate(speed, 0);
            }
        }
    }

    private void moveLeft() {

        if (picture.getX() != background.getX()){
            if (picture.getX() - speed < background.getX()) {
                picture.translate(background.getX() - picture.getX(), 0);
            } else {
                picture.translate(-speed, 0);
            }
        }

    }


    public void move()  {
        if (isMoving) {
            if (lookingRight) {
                moveRight();
            } else {
                moveLeft();
            }
        }
        for (Ball ball : balls) {
            if (collideWithBall(ball)) {
                delete();

            }
        }
    }

    public boolean collideWithBall(Ball ball) {

        int playerMidX = picture.getX() + picture.getWidth()/2;
        int playerMidY = picture.getY() + picture.getHeight()/2;

        // Collision with head
        if ((ball.getX() <= playerMidX && playerMidX <= ball.getMaxX()) && (ball.getY() <= picture.getY() && picture.getY() <= ball.getMaxY())) {
            return true;
        }

        // Collision with left side
        if ((ball.getY() <= playerMidY && playerMidY <= ball.getMaxY()) && (ball.getMaxX() >= picture.getX() && picture.getMaxX() >= ball.getMaxX())) {
            return true;
        }

        // Collision with right side
        if ((ball.getY() <= playerMidY && playerMidY <= ball.getMaxY()) && (ball.getX() <= picture.getMaxX() && picture.getX() <= ball.getX())) {
            return true;
        }

        return false;
    }

    public void delete() {

        picture.delete();
        isAlive = false;
        if (bullet != null) {
            bullet.delete();
        }

    }

    private void shoot() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        if (!isShooting) {
            bullet = new Bullet(picture.getX() + 20, picture.getY() + picture.getWidth()/2, background, this, balls);
            isShooting = true;
        }
    }

    public boolean isShooting() {
        return isShooting;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void setShooting(boolean bool) {
        isShooting = bool;
    }

    public Bullet getBullet() {
        return bullet;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                if (!lookingRight) {
                    lookingRight = true;
                    picture.load(picRight);
                }
                this.isMoving = true;
                break;

            case KeyboardEvent.KEY_LEFT:
                if (lookingRight) {
                    lookingRight = false;
                    picture.load(picLeft);
                }
                this.isMoving = true;
                break;

            case KeyboardEvent.KEY_SPACE:
                if (!isAlive) {
                    break;
                }

                if (!spaceIsHeld) {
                    spaceIsHeld = true;
                    try {
                        this.shoot();
                    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    isShooting = true;
                }

                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                this.isMoving = false;
                break;
            case KeyboardEvent.KEY_LEFT:
                this.isMoving = false;
                break;
            case KeyboardEvent.KEY_SPACE:
                this.spaceIsHeld = false;
        }
    }

}
