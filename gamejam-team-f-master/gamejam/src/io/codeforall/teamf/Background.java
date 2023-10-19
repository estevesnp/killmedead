package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture = new Picture(10, 10, "gamejam/resources/background.png");

    public Background() {
    }

    public void show() {
        picture.draw();
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
