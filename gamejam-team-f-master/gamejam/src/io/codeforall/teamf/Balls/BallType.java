package io.codeforall.teamf.Balls;

public enum BallType {
    SMALL(0.8, null, "gamejam/resources/small-ball.png"),
    MEDIUM(0.65, SMALL, "gamejam/resources/medium-ball.png"),
    BIG(0.5, MEDIUM, "gamejam/resources/big-ball.png");

    private double speed;
    private BallType nextBall;
    private String picOrigin;

    BallType(double speed, BallType nextBall, String picOrigin) {
        this.speed = speed;
        this.nextBall = nextBall;
        this.picOrigin = picOrigin;
    }

    public double getSpeed() {
        return this.speed;
    }

    public BallType getNextBall() {
        return this.nextBall;
    }

    public String getPicOrigin() {
        return this.picOrigin;
    }
}
