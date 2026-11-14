package LAB09;

/**
 * Tournament (1) <>---- (*) Round -- Round biet Tournament cua no tu luc tao.
 */
public class Round {
    private final int number;

    /* Khoi tao trong constructor, khong bao gio thay doi (aggregation). */
    private final Tournament tournament;

    public Round(int number, Tournament tournament) {
        if (tournament == null) {
            throw new IllegalArgumentException("tournament must not be null");
        }
        this.number = number;
        this.tournament = tournament;
        tournament.addRound(this);      // dong bo dau kia cua association
    }

    public int getNumber() {
        return number;
    }

    public Tournament getTournament() {
        return tournament;
    }
}