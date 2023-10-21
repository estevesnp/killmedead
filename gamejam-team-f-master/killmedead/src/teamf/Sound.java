package teamf;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {

    private Sound sound;

    private boolean inLoop;

    private Clip clip;
    public Sound() {

    }

    public void playSound (String filepath) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        sound = new Sound();

        URL url = this.getClass().getResource(filepath);

        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
        clip = (Clip) AudioSystem.getLine(info);
        clip.open(ais);
        clip.start();


        /*
        File audio = new File(filepath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
        clip.open(audioStream);
        clip.start();


         */


    }

  /*  public float getVolume() {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        return (float) Math.pow(10f, gainControl.getValue() / 20f);
    }

    public void setVolume(float volume) {
        if (volume < 0f || volume > 1f)
            throw new IllegalArgumentException("Volume not valid: " + volume);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(volume));
    }*/

    public void setInLoop(Boolean loop){
        this.inLoop = loop;
    }
    public Clip getClip() {
        return clip;
    }


}
