package io.codeforall.teamf;

public class Main {
    public static void main(String[] args) {

        Background background = new Background();
        Player player = new Player();

        Controls controls = new Controls(background, player);
    }

}
