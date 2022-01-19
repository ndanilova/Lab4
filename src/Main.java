import ecxeptions.InvalidDataException;
import ecxeptions.InvalidNumeralDataException;
import gear.*;
import people.*;
import someObjects.MeteoriteRain;
import someObjects.TeamMaker;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rocket rocket = new Rocket();
        try {
            rocket.setDurationOfUseInYears(5);
        } catch (InvalidNumeralDataException in) {
            in.printStackTrace();
        }
        TeamMaker teamMaker = new TeamMaker();
        List<Shorty> dreamTeam = teamMaker.makeGroup(new AllKnower("Znaika", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()),
                new Fuchsia("Fuksiya", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()),
                new HerringBone("Seledochka", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()),
                new LittleStar("Zvezdochkin", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()),
                new DontKnower("Neznaika", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()),
                new Chamomile("Romashka", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()));
        List<Shorty> newDreamTeam = teamMaker.divideTeam(dreamTeam, dreamTeam.get(0), dreamTeam.get(1), dreamTeam.get(2), dreamTeam.get(3));
        try {
            MeteoriteRain meteoriteRain = new MeteoriteRain(60, MeteoriteRain.MeteoriteSize.GIANT, rocket);
        } catch (InvalidDataException ex) {
            ex.printStackTrace();
        }
        Rocket.Report report = Shorty.checkRocket(rocket, newDreamTeam);
        System.out.println(report.toString());
        dreamTeam.get(0).doGear(dreamTeam.get(0).geoHammer, 100, dreamTeam);

    }
}
