package gear;

import people.Shorty;

public class GeoHammer extends Gear {
    public GeoHammer() {
        attach();
    }

    @Override
    public void useGear(Shorty shorty, int timeOfUse) {
        Ore result = searchForOre(timeOfUse);
        System.out.printf("%s had taken geologic hammer and got %s\n", shorty.getName(), result);
    }

    @Override
    void attach() {
        isAttach = true;
    }

    private Ore searchForOre(int t) {
        if (Math.random() <= 0.004 * t) return Ore.ANTI_MOON_ORE;
        else if (Math.random() <= 0.003 * t) return Ore.MOON_ORE;
        else if (Math.random() <= 0.002 * t) return Ore.FROZEN_ALIEN;
        else return Ore.ICE;
    }

    private enum Ore {
        ANTI_MOON_ORE, FROZEN_ALIEN, ICE, MOON_ORE

    }

}
