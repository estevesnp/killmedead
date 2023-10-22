package teamf;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.LineUnavailableException;

public class Menu implements KeyboardHandler {

    private Picture picture;
    private boolean gameStarted = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean canAdvance = false;

    public Menu() {
    }

    public void setPicture(String path) {
        picture = new Picture(10, 10, path);
    }

    public void show() {
        picture.draw();
    }

    public void delete() {
        picture.delete();
    }

    public boolean gameStarted() {
        return this.gameStarted;
    }

    public void setGameStarted(boolean bool) {
        gameStarted = bool;
    }

    public boolean canAdvance() {
        return canAdvance;
    }

    public void setCanAdvance(boolean bool) {
        canAdvance = bool;
    }
    public void nextChar() {
        if (Game.currChar != 90) {
            Game.currChar++;
        }
    }

    public void previousChar() {
        if (Game.currChar != 65) {
            Game.currChar--;
        }
    }

    public void init() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressedR = new KeyboardEvent();
        pressedR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedR.setKey(KeyboardEvent.KEY_R);

        KeyboardEvent pressedQ = new KeyboardEvent();
        pressedQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedQ.setKey(KeyboardEvent.KEY_Q);

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent pressedEnter = new KeyboardEvent();
        pressedEnter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedEnter.setKey(KeyboardEvent.KEY_ENTER);


        keyboard.addEventListener(pressedR);
        keyboard.addEventListener(pressedQ);
        keyboard.addEventListener(pressedUp);
        keyboard.addEventListener(pressedDown);
        keyboard.addEventListener(pressedEnter);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_R:
                gameStarted = true;
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_UP:
                    nextChar();
                break;
            case KeyboardEvent.KEY_DOWN:
                    previousChar();
                break;
            case KeyboardEvent.KEY_ENTER:
                canAdvance = true;
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
