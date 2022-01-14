package gear;

import conditions.Cord;
import people.Shorty;

public class JetSneakers extends Gear {
    public JetSneakers() {
        attach();
    }

    @Override
    public void useGear(Shorty shorty, int timeOfUse) {
        if (shorty.getWeight() == 0) {
            Cord cord = shorty.getCord();
            shorty.setCord(cord.getX(), cord.getY(), timeOfUse);
            System.out.printf("Can you hear this sound? That's because %s used jet sneakers and flew for %d meters!\n", shorty.getName(), timeOfUse);
        } else System.out.printf("%s can't use jet sneakers until he has weight\n", shorty.getName());

    }

    @Override
    void attach() {
        isAttach = true;
    }

}
