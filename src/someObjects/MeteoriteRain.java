package someObjects;

import exceptions.InvalidDataException;
import exceptions.InvalidNumeralDataException;
import gear.Rocket;

public class MeteoriteRain {
    private double durationInMinutes;
    private MeteoriteSize meteoriteSize;

    public MeteoriteRain(double durationInMinutes, MeteoriteSize meteoriteSize, Rocket rocket) throws InvalidDataException {
        if (durationInMinutes <= 0 || meteoriteSize == null || rocket == null) {
            throw new InvalidDataException("Incorrect data to Meteorite rain");
        } else {
            this.durationInMinutes = durationInMinutes;
            this.meteoriteSize = meteoriteSize;
            run(rocket);
        }

    }

    public MeteoriteRain() {
        this.durationInMinutes = 1;
        this.meteoriteSize = MeteoriteSize.SMALL;
    }

    public void setDurationInMinutes(double durationInMinutes) throws InvalidNumeralDataException {
        if (durationInMinutes <= 0) {
            throw new InvalidNumeralDataException("Invalid number for setting duration");
        } else {
            this.durationInMinutes = durationInMinutes;
        }

    }

    public void setMeteoriteSize(MeteoriteSize meteoriteSize) throws InvalidDataException {
        if (meteoriteSize == null) {
            throw new InvalidDataException("Invalid meteor size");
        } else {
            this.meteoriteSize = meteoriteSize;
        }

    }

    public void run(Rocket rocket) throws NullPointerException {
        if (rocket == null) {
            throw new NullPointerException("Rocket can't be null (MeteoriteRain.run)");
        } else {
            int durationRate;
            int sizeRate = 0;

            if (durationInMinutes <= 5) {
                durationRate = 1;
            } else if (durationInMinutes <= 15) {
                durationRate = 2;
            } else if (durationInMinutes <= 25) {
                durationRate = 3;
            } else if (durationInMinutes <= 40) {
                durationRate = 4;
            } else {
                durationRate = 5;
            }
            if (meteoriteSize == MeteoriteSize.SMALL) {
                sizeRate = 1;
            } else if (meteoriteSize == MeteoriteSize.MEDIUM) {
                sizeRate = 2;
            } else if (meteoriteSize == MeteoriteSize.BIG) {
                sizeRate = 3;
            } else if (meteoriteSize == MeteoriteSize.VERY_BIG) {
                sizeRate = 4;
            } else if (meteoriteSize == MeteoriteSize.GIANT) {
                sizeRate = 5;
            }
            rocket.crashBody(sizeRate + durationRate);
        }

    }


    public enum MeteoriteSize {
        GIANT, VERY_BIG, BIG, MEDIUM, SMALL
    }
}
