package teamf;

public enum BallType {
    SMALL(0.8, null, "Marg.png"),
    MEDIUM(0.65, SMALL, "Mario_ball.png"),
    BIG(0.5, MEDIUM, "Mic.png");

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
