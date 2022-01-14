package gear;

import people.Shorty;

public class IceChop extends Gear {
    public IceChop() {
        attach();
    }

    @Override
    public void useGear(Shorty shorty, int timeOfUse) {
        chopIce(shorty, timeOfUse);
    }

    @Override
    void attach() {
        isAttach = true;
    }

    private void chopIce(Shorty sh, int t) {
        System.out.printf("%s has chopped %d pieces of ice with ice chopper\n", sh.getName(), (int) (Math.random() * (t) + 1));
    }

}
