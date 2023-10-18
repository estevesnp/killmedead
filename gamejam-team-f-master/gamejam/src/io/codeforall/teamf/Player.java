package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Player implements KeyboardHandler {

    private Background background;
    private LinkedList<Ball> balls;
    private Bullet bullet;
    private String picRight = "gamejam/resources/mario.png";
    private String picLeft = "gamejam/resources/mario_reversed.png";

    private boolean lookingRight = true;
    private boolean isMoving = false;
    private boolean isShooting = false;
    private boolean spaceIsHeld = false;


    private Picture picture;
    private double speed = 0.5;

    public Player(Background background, LinkedList<Ball> balls) {

        this.background = background;
        this.balls = balls;
        init();
    }

    private void init() {
        picture = new Picture(background.getX(), background.getMaxY(), picRight);
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


    public void move() {
        if (isMoving) {
            if (lookingRight) {
                moveRight();
            } else {
                moveLeft();
            }
        }
    }

    private void shoot() {
        if (!isShooting) {
            bullet = new Bullet(picture.getX() + 20, picture.getY(), background, this, balls);
            isShooting = true;
        }
    }

    public boolean isShooting() {
        return isShooting;
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
                if (!spaceIsHeld) {
                    spaceIsHeld = true;
                    this.shoot();
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
