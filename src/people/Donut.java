package people;

import clothes.Clothes;
import gear.*;

public class Donut extends Shorty {

    public Donut(String name, int weight, GeoHammer geoHammer, AlpenShtock alpenShtock, IceChop iceChop, JetSneakers jetSneakers, WeightLessNess weightLessNess) {
        super(name, weight, geoHammer, alpenShtock, iceChop, jetSneakers, weightLessNess);
        setClothes(Clothes.SPACESUIT);

    }
}
