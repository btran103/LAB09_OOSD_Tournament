package LAB09;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Tournament (*) ----- (*) Player : many-to-many, hai chieu.
 * Player giu Set<Tournament>; Tournament giu Set<Player>.
 */
public class Player {
    private final String name;
    private final Set<Tournament> tournaments = new HashSet<Tournament>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Tournament> getTournaments() {
        return Collections.unmodifiableSet(tournaments);
    }

    /**
     * Package-private: de duy tri tinh nhat quan hai chieu, nguoi dung
     * nen goi Tournament.addPlayer(p) thay vi goi truc tiep ham nay.
     */
    void addTournament(Tournament t) {
        if (tournaments.add(t)) {
            t.addPlayer(this);
        }
    }

    void removeTournament(Tournament t) {
        if (tournaments.remove(t)) {
            t.removePlayer(this);
        }
    }
}