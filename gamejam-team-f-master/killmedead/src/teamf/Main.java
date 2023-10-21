package teamf;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, LineUnavailableException, UnsupportedAudioFileException, IOException {

        Game g = new Game();

        while (true) {
            g.startMenu();
            g.init();
            g.start();
        }
    }

}
