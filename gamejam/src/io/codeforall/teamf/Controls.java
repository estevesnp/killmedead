package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Controls implements KeyboardHandler {


    public Controls() {
        init();
    }

    public void init() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(pressedDown);

        KeyboardEvent pressedO = new KeyboardEvent();
        pressedO.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedO.setKey(KeyboardEvent.KEY_O);
        keyboard.addEventListener(pressedO);

        KeyboardEvent pressedP = new KeyboardEvent();
        pressedP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedP.setKey(KeyboardEvent.KEY_P);
        keyboard.addEventListener(pressedP);


        KeyboardEvent pressedR = new KeyboardEvent();
        pressedR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedR.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(pressedR);

        KeyboardEvent releasedR = new KeyboardEvent();
        releasedR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedR.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(releasedR);


        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressedSpace);

        KeyboardEvent releasedSpace = new KeyboardEvent();
        releasedSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(releasedSpace);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                break;
            case KeyboardEvent.KEY_LEFT:
                break;
            case KeyboardEvent.KEY_UP:
                break;
            case KeyboardEvent.KEY_DOWN:
                break;
            case KeyboardEvent.KEY_O:
                break;
            case KeyboardEvent.KEY_P:
                break;
            case KeyboardEvent.KEY_R:
                break;
            case KeyboardEvent.KEY_SPACE:
                break;

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_R:
                break;

            case KeyboardEvent.KEY_SPACE:
                break;
        }

    }





}