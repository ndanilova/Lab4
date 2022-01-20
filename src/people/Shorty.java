package people;

import exceptions.EmptyDataException;
import exceptions.InvalidNumeralDataException;
import gear.*;
import someObjects.Team;
import specificActions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shorty extends HumanLike implements ClapAble, Cryable, Shoutable {
    public GeoHammer geoHammer;
    public AlpenShtock alpenShtock;
    public IceChop iceChop;
    public JetSneakers jetSneakers;
    public WeightLessNess weightLessNess;

    Shorty(String name, int weight, GeoHammer geoHammer, AlpenShtock alpenShtock, IceChop iceChop, JetSneakers jetSneakers, WeightLessNess weightLessNess) throws EmptyDataException {
        super(name, weight);
        if (name == null || weight <= 0 || geoHammer == null || alpenShtock == null || iceChop == null || jetSneakers == null || weightLessNess == null) {
            throw new EmptyDataException("Invalid data given to constructor (Shorty)");
        }
        this.geoHammer = geoHammer;
        this.alpenShtock = alpenShtock;
        this.iceChop = iceChop;
        this.jetSneakers = jetSneakers;
        this.weightLessNess = weightLessNess;
    }

    public void doGear(Gear gear, int t, List<Shorty> shortyes) throws IllegalArgumentException {
        if (gear == null || t <= 0 || shortyes == null) {
            throw new IllegalArgumentException("Invalid argument for Shorty.doGear");
        }
        for (Shorty shorty : shortyes) {
            gear.useGear(shorty, t);
        }

    }

    public static void doGear(Gear gear, List<Shorty> shortyes) {
        for (Shorty shorty : shortyes)
            gear.useGear(shorty, 5);
    }

    public List<Team> divideFromIndex(List<Shorty> shorties, int index) throws EmptyDataException {
        if (shorties == null || shorties.isEmpty()) {
            throw new EmptyDataException("Invalid data given to Shorty.divideFromIndex (list is empty)");
        }
        if (index <= 0) {
            throw new EmptyDataException("your index can't be zero or less");
        }
        List<Shorty> shorties1 = shorties.subList(0, index);
        List<Shorty> shorties2 = shorties.subList(index, shorties.size());
        Team team1 = new Team(shorties1);
        Team team2 = new Team(shorties2);
        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        System.out.printf("\n%s has decided to divide the team\n\nTeam number one will contain:\n",getName());
        for (Shorty sh:
             team1.getShorties()) {
            System.out.println(sh.getName());
        }
        System.out.println();
        System.out.println("Team number two will contain:");
        for (Shorty sh:
                team2.getShorties()) {
            System.out.println(sh.getName());
        }
        System.out.println();
        return teams;
    }

    public boolean everythingReady() {
        return alpenShtock.checkAttach() && geoHammer.checkAttach() && iceChop.checkAttach() && jetSneakers.checkAttach() && weightLessNess.checkAttach();
    }

    @Override
    public void clap(String name) {
        System.out.printf("%s claps with respect\n", name);
    }

    @Override
    public void cry(String name) {
        System.out.printf("%s is crying miserably\n", name);
    }

    @Override
    public void shout(String name) {
        System.out.printf("%s can't stop shouting\n", name);
    }

    public void shout(String... names) {
        for (String name : names) System.out.printf("%s can't stop shouting\n", name);
    }

    public void cry(String... names) {
        for (String name : names) System.out.printf("%s is crying miserably\n", name);
    }

    public void clap(String... names) {
        for (String name : names) System.out.printf("%s claps with respect\n", name);
    }

    public static Rocket.Report checkRocket(Rocket rocket, List<Shorty> shorties) throws EmptyDataException {
        if (rocket == null || shorties.isEmpty()) {
            throw new EmptyDataException("Invalid arguments for this method");
        }
        return rocket.giveInfoAboutModules(shorties);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shorty shorty = (Shorty) o;
        return Objects.equals(geoHammer, shorty.geoHammer) && Objects.equals(alpenShtock, shorty.alpenShtock) && Objects.equals(iceChop, shorty.iceChop) && Objects.equals(jetSneakers, shorty.jetSneakers) && Objects.equals(weightLessNess, shorty.weightLessNess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), geoHammer, alpenShtock, iceChop, jetSneakers, weightLessNess);
    }

    @Override
    public String toString() {
        return "Shorty{" + "geoHammer=" + geoHammer + ", alpenShtock=" + alpenShtock + ", iceChop=" + iceChop + ", jetSneakers=" + jetSneakers + ", weightLessNess=" + weightLessNess + '}';
    }
}
