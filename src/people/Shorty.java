package people;

import gear.*;
import specificActions.ClapAble;
import specificActions.Cryable;
import specificActions.Shoutable;

import java.util.Objects;

public class Shorty extends HumanLike implements ClapAble, Cryable, Shoutable {
    public GeoHammer geoHammer;
    public AlpenShtock alpenShtock;
    public IceChop iceChop;
    public JetSneakers jetSneakers;
    public WeightLessNess weightLessNess;

    Shorty(String name, int weight, GeoHammer geoHammer, AlpenShtock alpenShtock, IceChop iceChop, JetSneakers jetSneakers, WeightLessNess weightLessNess) {
        super(name, weight);
        this.geoHammer = geoHammer;
        this.alpenShtock = alpenShtock;
        this.iceChop = iceChop;
        this.jetSneakers = jetSneakers;
        this.weightLessNess = weightLessNess;
    }

    public void doGear(Gear gear, int t, Shorty... shortyes) {
        for (Shorty shorty : shortyes)
            gear.useGear(shorty, t);
    }

    public void doGear(Gear gear, Shorty... shortyes) {
        for (Shorty shorty : shortyes)
            gear.useGear(shorty, 5);
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

    public static void shout(String... names) {
        for (String name : names) System.out.printf("%s can't stop shouting\n", name);
    }

    public static void cry(String... names) {
        for (String name : names) System.out.printf("%s is crying miserably\n", name);
    }

    public static void clap(String... names) {
        for (String name : names) System.out.printf("%s claps with respect\n", name);
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
