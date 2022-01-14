package conditions;

import java.util.Objects;

public class Cord {
    private int x;
    private int y;
    private int z = 1;

    public Cord() {
        x = (int) (Math.random() * 10);
        y = (int) (Math.random() * 10);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cord cord = (Cord) o;
        return x == cord.x && y == cord.y && z == cord.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Cord{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
