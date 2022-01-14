package people;

import clothes.Clothes;
import gear.*;

public class DontKnower extends Shorty {

    public DontKnower(String name, int weight, GeoHammer geoHammer, AlpenShtock alpenShtock, IceChop iceChop, JetSneakers jetSneakers, WeightLessNess weightLessNess) {
        super(name, weight, geoHammer, alpenShtock, iceChop, jetSneakers, weightLessNess);
        setClothes(Clothes.SPACESUIT);
    }
}
