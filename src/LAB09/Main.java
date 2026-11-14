package LAB09;

public class Main {
    public static void main(String[] args) {
        League league = new League("Summer League");
        Tournament t1 = new Tournament("Cup A", league);
        Tournament t2 = new Tournament("Cup B", league);
        Round r1 = new Round(1, t1);
        Round r2 = new Round(2, t1);

        Player an = new Player("An");
        Player binh = new Player("Binh");

        t1.addPlayer(an);
        t1.addPlayer(binh);
        binh.addTournament(t2);          // goi tu phia Player cung phai dong bo

        System.out.println("League tournaments : " + league.getTournaments().size());      // 2
        System.out.println("Cup A rounds       : " + t1.getRounds().size());                // 2
        System.out.println("r1.tournament      : " + r1.getTournament().getName());         // Cup A
        System.out.println("Cup A players      : " + t1.getPlayers().size());               // 2
        System.out.println("Binh tournaments   : " + binh.getTournaments().size());         // 2
        System.out.println("Cup B has Binh     : " + t2.getPlayers().contains(binh));       // true

        t1.removePlayer(binh);
        System.out.println("After remove: Binh tournaments = " + binh.getTournaments().size()); // 1
        System.out.println("After remove: Cup A players    = " + t1.getPlayers().size());       // 1
    }
}