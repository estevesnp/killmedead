package teamf;


import java.util.ArrayList;

public class LevelGenerator {

    public static void generateLevel(int lvl, ArrayList<Ball> balls, Background background) {

        switch (lvl) {
            case 1:
                generateBall(1, BallType.MEDIUM, balls, background);
                break;
            case 2:
                generateBall(1, BallType.BIG, balls, background);
                break;
            case 3:
                generateBall(1, BallType.MEDIUM, balls, background);
                generateBall(1, BallType.BIG, balls, background);
                break;
            default:
                generateBall(lvl - 2, BallType.BIG, balls, background);
        }

    }

    private static void generateBall(int numBalls, BallType ballType, ArrayList<Ball> balls, Background background) {
        for (int i = 0; i < numBalls; i++) {
            balls.add(new Ball(background, ballType));
        }
    }
}
