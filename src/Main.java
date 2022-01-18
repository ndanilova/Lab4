import gear.*;
import people.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rocket rocket = new Rocket();
        rocket.beUnusedForSomeHours(30);
        AllKnower allKnower = new AllKnower("Znaika", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess());
        Donut donut = new Donut("Ponchick", 8, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess());
        Chamomile chamomile = new Chamomile("Romashka", 22, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess());
        DontKnower dontKnower = new DontKnower("Neznaika", 40, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess());
        Fuchsia fuchsia = new Fuchsia("Neznaika", 40, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess());
        LittleStar littleStar = new LittleStar("Neznaika", 40, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess());
        HerringBone herringBone = new HerringBone("Neznaika", 40, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess());
        List<Shorty> team1 = allKnower.divide(allKnower, fuchsia, littleStar, herringBone);
        List<Shorty> team2 = dontKnower.divide(dontKnower, donut, chamomile);
        String info = rocket.beChecked(team1);
        System.out.println("Guys checked spaceship and found out that\n" + info);
        dontKnower.doGear(dontKnower.geoHammer, 40, team2);
    }
}
