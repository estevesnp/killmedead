package teamf;

public enum BallType {
    SMALL(0.8, null),
    MEDIUM(0.65, SMALL),
    BIG(0.5, MEDIUM);

    private double speed;
    private BallType nextBall;
    private String picOrigin;

    BallType(double speed, BallType nextBall) {
        this.speed = speed;
        this.nextBall = nextBall;
    }

    public double getSpeed() {
        return this.speed;
    }

    public BallType getNextBall() {
        return this.nextBall;
    }

    public String getPicOrigin() {

        switch (this) {
            case BIG:
                return Math.random() < 0.5 ? "Mic.png" : "nozk.png";
            case MEDIUM:
                return Math.random() < 0.5 ? "Marg.png" : "Mario_ball.png";
            default:
                return Math.random() < 0.5 ? "zuka.png" : "clau.png";
        }

    }
}
