package people;

import clothes.Clothes;
import conditions.Condition;
import conditions.Cord;

import java.util.Objects;

public class HumanLike {
    private int weight;
    private final int actuallWeight;
    private final String name;
    private Condition condition;
    private Clothes clothes;
    private Cord cord;

    HumanLike(String name, int weight) {
        this.condition = Condition.NORMAL;
        this.clothes = Clothes.UNKNOWN;
        this.name = name;
        this.weight = weight;
        actuallWeight = weight;
        this.cord = new Cord();
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getActuallWeight() {
        return actuallWeight;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getName() {
        return name;
    }

    static public void standInLine(HumanLike... humen) {
        Cord pos = humen[0].getCord();
        for (HumanLike humanLike : humen) {
            humanLike.setCord(pos.getX(), pos.getY(), pos.getZ());
            pos.setX(pos.getX() + 1);
        }
        System.out.println("The crue have stood in one line!");
    }

    public void throwHat() {
        System.out.println("Подбрасывает шляпу");

    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setCord(int x, int y, int z) {
        cord.setX(x);
        cord.setY(y);
        cord.setZ(z);
    }

    public Cord getCord() {
        return cord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanLike humanLike = (HumanLike) o;
        return weight == humanLike.weight && actuallWeight == humanLike.actuallWeight && Objects.equals(name, humanLike.name) && condition == humanLike.condition && clothes == humanLike.clothes && Objects.equals(cord, humanLike.cord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, actuallWeight, name, condition, clothes, cord);
    }

    @Override
    public String toString() {
        return "HumanLike{" +
                "weight=" + weight +
                ", actuallWeight=" + actuallWeight +
                ", name='" + name + '\'' +
                ", condition=" + condition +
                ", clothes=" + clothes +
                ", cord=" + cord +
                '}';
    }

}


