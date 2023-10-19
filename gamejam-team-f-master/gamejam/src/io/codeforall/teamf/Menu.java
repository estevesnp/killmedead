package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private Picture picture = new Picture(10, 10, "gamejam/resources/menu.png");
    private boolean gameStarted = false;

    public Menu() {
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

        keyboard.addEventListener(pressedR);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            gameStarted = true;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
