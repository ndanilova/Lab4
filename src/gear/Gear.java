package gear;

import people.Shorty;

import java.util.Objects;

public abstract class Gear {
    protected boolean isAttach;

    abstract public void useGear(Shorty shorty, int timeOfUse);

    abstract void attach();

    public boolean checkAttach() {
        return isAttach;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "isAttach=" + isAttach +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gear gear = (Gear) o;
        return isAttach == gear.isAttach;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAttach);
    }
}
