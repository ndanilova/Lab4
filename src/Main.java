import exceptions.InvalidDataException;
import exceptions.InvalidNumeralDataException;
import gear.*;
import people.*;
import someObjects.MeteoriteRain;
import someObjects.Team;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shorty> shorties = new ArrayList<>();
        shorties.add(new AllKnower("Znaika", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()));
        shorties.add(new Fuchsia("Fuksiya", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()));
        shorties.add(new HerringBone("Seledochka", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()));
        shorties.add(new LittleStar("Zvezdochkin", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()));
        shorties.add(new DontKnower("Neznaika", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()));
        shorties.add(new Chamomile("Romashka", 47, new GeoHammer(), new AlpenShtock(), new IceChop(), new JetSneakers(), new WeightLessNess()));
        List<Team> teams = shorties.get(0).divideFromIndex(shorties, 4);
        Team firstTeam1 = teams.get(0);
        Team secondTeam = teams.get(1);
        Rocket rocket = new Rocket();
        try {
            rocket.setDurationOfUseInYears(5);
        } catch (InvalidNumeralDataException in) {
            in.printStackTrace();
        }
        try {
            MeteoriteRain meteoriteRain = new MeteoriteRain(60, MeteoriteRain.MeteoriteSize.GIANT, rocket);
        } catch (InvalidDataException ex) {
            ex.printStackTrace();
        }
        Rocket.Report report = Shorty.checkRocket(rocket, firstTeam1.getShorties());
        System.out.println(report.toString());
        try {
            secondTeam.getShorty(0).doGear(secondTeam.getShorty(0).geoHammer, 100, secondTeam.getShorties());
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

    }
}
