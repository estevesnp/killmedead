package io.codeforall.teamf;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    Picture picture = new Picture(0, 0, "resources/background.png");


    public Background() {
        picture.draw();
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
