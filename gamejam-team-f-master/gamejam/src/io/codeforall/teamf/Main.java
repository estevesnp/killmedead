package io.codeforall.teamf;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        Game g = new Game();

        while (true) {
            g.startMenu();
            g.init();
            g.start();
        }
    }

}
