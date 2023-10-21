package teamf;

public class PlayersLeaderboard implements Comparable<PlayersLeaderboard>{

    private String name;

    private int score;

    public PlayersLeaderboard(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(PlayersLeaderboard o) {
        return o.score - score;
    }

    @Override
    public String toString() {
        return name + ":" + score;
    }
}
