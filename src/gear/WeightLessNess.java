package gear;

import conditions.Condition;
import people.Shorty;

public class WeightLessNess extends Gear {
    public WeightLessNess() {
        attach();
    }

    @Override
    public void useGear(Shorty shorty, int timeOfUse) {
        shorty.setWeight(0);
        shorty.setCondition(Condition.WEIGHTLESSNESS);
    }

    public void deactivate(Shorty shorty) {
        shorty.setWeight(shorty.getActuallWeight());
        shorty.setCondition(Condition.WEIGHTLESSNESS);
    }

    @Override
    void attach() {
        isAttach = true;
    }
}
