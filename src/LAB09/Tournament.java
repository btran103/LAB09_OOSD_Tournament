package LAB09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * League (1) <>---- (*) Tournament   : Tournament giu tham chieu league (final)
 * Tournament (1) <>---- (*) Round    : Tournament giu danh sach rounds
 * Tournament (*) ----- (*) Player    : many-to-many, hai chieu
 */
public class Tournament {
    private final String name;

    /* Khoi tao trong constructor, khong bao gio thay doi (aggregation). */
    private final League league;

    private final List<Round> rounds = new ArrayList<Round>();
    private final Set<Player> players = new HashSet<Player>();

    public Tournament(String name, League league) {
        if (league == null) {
            throw new IllegalArgumentException("league must not be null");
        }
        this.name = name;
        this.league = league;
        league.addTournament(this);     // dong bo dau kia cua association
    }

    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
    }

    // ---- Tournament 1 <>--- * Round (chi them, khong xoa) ----
    public List<Round> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    /** Package-private: chi Round.<init> goi. */
    void addRound(Round r) {
        if (!rounds.contains(r)) {
            rounds.add(r);
        }
    }

    // ---- Tournament * --- * Player (hai chieu, thay doi duoc) ----
    public Set<Player> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public void addPlayer(Player p) {
        if (players.add(p)) {           // false neu da co -> dung de tranh de quy vo han
            p.addTournament(this);
        }
    }

    public void removePlayer(Player p) {
        if (players.remove(p)) {
            p.removeTournament(this);
        }
    }
}