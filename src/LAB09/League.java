package LAB09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * League (1) <>---- (*) Tournament   -- aggregation, KHONG doi sau khi tao.
 * League la "chu" nen chi giu danh sach Tournament.
 */
public class League {
    private final String name;
    private final List<Tournament> tournaments = new ArrayList<Tournament>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Chi doc: ben ngoai khong the them/xoa truc tiep vao danh sach. */
    public List<Tournament> getTournaments() {
        return Collections.unmodifiableList(tournaments);
    }

    /**
     * Package-private: CHI Tournament (cung package) duoc goi, tu constructor
     * cua Tournament. Khong co removeTournament vi aggregation khong doi.
     */
    void addTournament(Tournament t) {
        if (!tournaments.contains(t)) {
            tournaments.add(t);
        }
    }
}