package gear;

import exceptions.InvalidNumeralDataException;
import exceptions.NoGasException;
import people.Shorty;
import specificActions.Checkable;
import specificActions.Crashable;

import java.util.List;

public class Rocket {
    private int numOfFuel;
    private Engine engine;
    private Body body;
    private double durationOfUseInYears;
    private int fuelConsumption;

    private enum EngineCond {
        GOOD, MEDIUM, BAD, VERY_BAD, OUT_OF_ORDER
    }

    public class Engine {
        private int power;
        private boolean activation;
        private EngineCond engineCond;

        public Engine() {
            power = 500;
            engineCond = EngineCond.GOOD;
        }

        protected void run() {
            try {
                useFuel();
                this.activation = true;
                this.power -= 10;
                if (this.power <= 0) {
                    becomeOutOfOrder();
                } else if (this.power <= 50) {
                    engineCond = EngineCond.VERY_BAD;
                } else if (this.power <= 100) {
                    engineCond = EngineCond.BAD;
                } else if (this.power <= 200) {
                    engineCond = EngineCond.MEDIUM;
                }
            } catch (NoGasException e) {
                e.printStackTrace();
            }
        }

        public void deactivateEngine() {
            this.activation = false;
        }

        public EngineCond getEngineCond() {
            return engineCond;
        }

        private void becomeOutOfOrder() {
            engineCond = EngineCond.OUT_OF_ORDER;
            System.out.println("It seems that your engine needs help");
        }

    }

    private enum BodyCond {
        NO_SCRATCH, SCRATCHED, DENTS, CRACKED, KILL_ME
    }

    public class Body {
        private BodyCond bodyCond;

        Body() {
            bodyCond = BodyCond.NO_SCRATCH;
        }


        public void setBodyCond(BodyCond bodyCond) throws NullPointerException {
            if (bodyCond == null) {
                throw new NullPointerException("Invalid cond for body");
            }
            if (bodyCond != BodyCond.KILL_ME) {
                this.bodyCond = bodyCond;
            } else {
                destroyBody();
            }
        }

        private void destroyBody() {
            this.bodyCond = BodyCond.KILL_ME;
            class Window implements Crashable {
                public void crash() {
                    System.out.println("poor rocket is covered by glass fragments");
                }
            }
            Window window = new Window();
            window.crash();
        }

        public BodyCond getBodyCond() {
            return bodyCond;
        }
    }

    public static class Manual {
        private static final String info = "Max speed = 12000km/h" + "material = aluminium" + "needed instruments = wrench, soldering iron, saw, clincher, screw" + "weight = 308tons" + "Nasa's property";
        private static int NumberOfFixes;

        public static void setNumberOfFixes(int numberOfFixes) throws InvalidNumeralDataException {
            if (numberOfFixes <= 0) {
                throw new InvalidNumeralDataException("number of fixes can't be like that!");
            } else {
                NumberOfFixes = numberOfFixes;
            }

        }

        public static int getNumberOfFixes() {
            return NumberOfFixes;
        }

        public static String getInfo() {
            return info;
        }
    }

    public static class NumOfRockets {
        private static int numOfRockets;

        public static void setNumOfRockets() {
            numOfRockets += 1;
        }

        public static int getNumOfRockets() {
            return numOfRockets;
        }
    }

    public Rocket() {
        NumOfRockets.setNumOfRockets();
        this.durationOfUseInYears = 1;
        fuelConsumption = 20;
        this.numOfFuel = 1000;
        class VehicleNumber {
            private int vehicleNumber;

            public VehicleNumber() {
                this.vehicleNumber = NumOfRockets.getNumOfRockets() * 31;
            }

            public int getVehicleNumber() {
                return vehicleNumber;
            }

            public void setVehicleNumber(int vehicleNumber) throws InvalidNumeralDataException {
                if (vehicleNumber <= 0) {
                    throw new InvalidNumeralDataException("You can't give that vehicle that number!");
                }
                this.vehicleNumber = vehicleNumber;

            }
        }

        VehicleNumber vehicleNumber = new VehicleNumber();
        this.engine = new Engine();
        this.body = new Body();
    }

    private void setFuelConsumption(int durationOfUseInYears) throws InvalidNumeralDataException {
        if (durationOfUseInYears <= 0) {
            throw new InvalidNumeralDataException("Invalid number of using duration");
        }
        this.fuelConsumption = (durationOfUseInYears * 10) + 10;


    }

    public void setDurationOfUseInYears(double durationOfUseInYears) throws InvalidNumeralDataException {
        if (durationOfUseInYears <= 0) {
            throw new InvalidNumeralDataException("Invalid number of using duration");
        }
        this.durationOfUseInYears = durationOfUseInYears;
        setFuelConsumption((int) durationOfUseInYears);


    }

    public void crashBody(int destructivenessRate) {
        if (destructivenessRate >= 8) {
            body.setBodyCond(BodyCond.KILL_ME);
        } else if (destructivenessRate >= 6) {
            body.setBodyCond(BodyCond.DENTS);
        } else if (destructivenessRate >= 3) {
            body.setBodyCond(BodyCond.CRACKED);
        } else if (destructivenessRate > 0) {
            body.setBodyCond(BodyCond.SCRATCHED);
        } else {
            body.setBodyCond(BodyCond.NO_SCRATCH);
        }
    }

    public int getNumOfFuel() {
        return numOfFuel;
    }

    public void useFuel() throws NoGasException {
        if (numOfFuel - fuelConsumption >= 0) {
            numOfFuel -= fuelConsumption;
        } else {
            throw new NoGasException("Hey, you ain't have enough juice for it!");
        }
    }

    public class Report {
        private EngineCond engineCond;
        private BodyCond bodyCond;
        private int numOfFuel;

        public Report() {
            this.engineCond = EngineCond.GOOD;
            this.bodyCond = BodyCond.NO_SCRATCH;
            this.numOfFuel = getNumOfFuel();
        }

        protected void setBodyCond(BodyCond bodyCond) {
            this.bodyCond = bodyCond;
        }

        protected void setEngineCond(EngineCond engineCond) {
            this.engineCond = engineCond;
        }

        protected void setNumOfFuel() {
            this.numOfFuel = getNumOfFuel();
        }

        public Report getReport() {
            return new Report();
        }

        @Override
        public String toString() {
            return "Report{" + "engineCond=" + engineCond + ", bodyCond=" + bodyCond + ", numOfFuel=" + numOfFuel + '}';
        }
    }

    public void activateEngine() throws NoGasException {
        if (numOfFuel <= 0) {
            throw new NoGasException("No juice!");
        } else {
            engine.run();
        }
    }

    public Report giveInfoAboutModules(List<Shorty> shorties) throws NullPointerException {
        Checkable checking = new Checkable() {
            @Override
            public Report check() {
                Report report = new Report();
                report.setBodyCond(body.bodyCond);
                report.setEngineCond(engine.engineCond);
                report.setNumOfFuel();
                return report;
            }
        };
        Report report = checking.check();
        if (shorties == null || shorties.isEmpty()) {
            throw new NullPointerException("Your List of Shorties is empty, no one can check the spaceship");
        }

        for (Shorty shorty : shorties) {
            System.out.printf("%s took part in checking the spaceship\n", shorty.getName());
        }

        return report;
    }

}