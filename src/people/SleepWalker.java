package people;

import clothes.Clothes;
import conditions.Cord;
import specificActions.ClapAble;
import specificActions.Cryable;
import specificActions.Shoutable;

import java.util.Objects;

public class SleepWalker extends HumanLike implements ClapAble, Cryable, Shoutable {
    private Cord cord = new Cord();

    public SleepWalker(String name, int weight) {
        super(name, weight);
        setClothes(Clothes.ALIENWEAR);
    }

    @Override
    public void clap(String name) {
        System.out.printf("%s claps with tentacles\n", name);
    }

    @Override
    public void cry(String name) {
        System.out.printf("%s is dropping acid tears\n", name);
    }

    @Override
    public void shout(String name) {
        System.out.printf("%s is shouting in the incomprehensible\n", name);
    }

    public static void shout(String... names) {
        for (String name : names) System.out.printf("%s is shouting in the incomprehensible\n", name);
    }

    public static void cry(String... names) {
        for (String name : names) System.out.printf("%s is dropping acid tears\n", name);
    }

    public static void clap(String... names) {
        for (String name : names) System.out.printf("%s claps with tentacles\n", name);
    }

    public static void throwHat(String... names) {
        for (String name : names)
            System.out.printf("%s is throwing it's hat\n", name);

    }

    public static void jump(String... names) {
        for (String name : names)
            System.out.printf("%s is jumping crazily\n", name);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SleepWalker that = (SleepWalker) o;
        return Objects.equals(cord, that.cord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cord);
    }

    @Override
    public String toString() {
        return "SleepWalker{" +
                "cord=" + cord +
                '}';
    }
}
