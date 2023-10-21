package teamf;


import java.util.ArrayList;

public class LevelGenerator {

    public static void generateLevel(int lvl, ArrayList<Ball> balls, Background background) {

        for (int i = 0; i < lvl; i++) {
            balls.add(new Ball(background, BallType.BIG));
        }
    }
}
