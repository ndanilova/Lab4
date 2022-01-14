package gear;

import conditions.Cord;
import people.Shorty;

public class AlpenShtock extends Gear {
    public AlpenShtock() {
        attach();
    }

    @Override
    public void useGear(Shorty shorty, int timeOfUse) {
        climb(shorty, timeOfUse);
        System.out.printf("%s is climbing using the alpenshtock\n", shorty.getName());
    }

    @Override
    void attach() {
        isAttach = true;
    }

    private void climb(Shorty shorty, int t) {
        Cord cord = shorty.getCord();
        shorty.setCord(cord.getX(), cord.getY(), t);
    }

}
