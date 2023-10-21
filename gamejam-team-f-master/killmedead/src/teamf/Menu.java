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

    public Menu(String path) throws LineUnavailableException {
        picture = new Picture(10, 10, path);
        init();
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

    private void init() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressedR = new KeyboardEvent();
        pressedR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedR.setKey(KeyboardEvent.KEY_R);

        KeyboardEvent pressedQ = new KeyboardEvent();
        pressedQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedQ.setKey(KeyboardEvent.KEY_Q);

        keyboard.addEventListener(pressedR);
        keyboard.addEventListener(pressedQ);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_R:
                gameStarted = true;
                break;
            case KeyboardEvent.KEY_Q:

        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            gameStarted = true;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
