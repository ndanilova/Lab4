package gear;

import ecxeptions.NoGasEcxeption;
import people.Shorty;
import specificActions.Checkable;
import specificActions.Crashable;

import java.util.List;

public class Rocket {
    private int numOfFuel;
    public Engine engine;
    public Body body;

    public class Engine {
        private int power;
        private boolean activation;
        private EngineCond engineCond;

        public Engine() {
            power = 500;
            engineCond = EngineCond.GOOD;
        }

        public void activateEngine(Rocket rocket) {
            try {
                rocket.useFuel();
            } catch (NoGasEcxeption e) {
                e.printStackTrace();
            }
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

        private enum EngineCond {
            GOOD, MEDIUM, BAD, VERY_BAD, OUT_OF_ORDER
        }
    }

    public class Body {
        private BodyCond bodyCond;

        Body() {
            bodyCond = BodyCond.NO_SCRATCH;
        }

        private enum BodyCond {
            NO_SCRATCH, SCRATCHED, DENTS, CRACKED, KILL_ME
        }

        public void setBodyCond(BodyCond bodyCond) {
            this.bodyCond = bodyCond;
        }

        public void breakBody() {
            this.bodyCond = BodyCond.KILL_ME;
            class Window implements Crashable {
                public void crash() {
                    System.out.println("poor rocket is covered by glass fragments");
                }
            }
        }

        public BodyCond getBodyCond() {
            return bodyCond;
        }
    }

    public static class Manual {
        private static final String info = new String("" +
                "Max speed = 12000km/h" +
                "material = aluminium" +
                "needed instruments = wrench, soldering iron, saw, clincher, screw" +
                "weight = 308tons" +
                "Nasa's property");
        private static int NumberOfFixes;

        public static void setNumberOfFixes(int numberOfFixes) {
            NumberOfFixes = numberOfFixes;
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
        this.numOfFuel = 1000;
        class VehicleNumber {
            private int vehicleNumber;

            public VehicleNumber() {
                this.vehicleNumber = NumOfRockets.getNumOfRockets() * 31;
            }

            public int getVehicleNumber() {
                return vehicleNumber;
            }

            public void setVehicleNumber(int vehicleNumber) {
                this.vehicleNumber = vehicleNumber;
            }
        }

        VehicleNumber vehicleNumber = new VehicleNumber();
        this.engine = new Engine();
        this.body = new Body();
    }

    public void beUnusedForSomeHours(int time) {
        if (time >= 20) {
            body.breakBody();
        } else if (time >= 10) {
            body.setBodyCond(Body.BodyCond.DENTS);
        } else if (time >= 5) {
            body.setBodyCond(Body.BodyCond.CRACKED);
        } else if (time >= 1) {
            body.setBodyCond(Body.BodyCond.SCRATCHED);
        }
    }

    public void useFuel() throws NoGasEcxeption {
        if (numOfFuel - 20 >= 0) {
            numOfFuel -= 20;
        } else {
        throw new NoGasEcxeption("Hey, you ain't have enough juice for it!");
        }
    }

    public String beChecked(Shorty... shorties) {
        var checking = new Checkable() {
            @Override
            public String check() {
                String result = new String(engine.getEngineCond().toString());
                result += "\n" + body.getBodyCond();
                return result;
            }
        };
        String answer = checking.check();
        for (Shorty shorty :
                shorties) {
            System.out.printf("\n %s took part in checking the spaceship", shorty.getName());
        }
        return answer;
    }
    public String beChecked(List<Shorty> shorties) {
        var checking = new Checkable() {
            @Override
            public String check() {
                String result = new String("\nEngine is "+engine.getEngineCond().toString());
                result += "\n" + "Body is " + body.getBodyCond();
                return result;
            }
        };
        String answer = checking.check();
        for (Shorty shorty :
                shorties) {
            System.out.printf("%s took part in checking the spaceship\n", shorty.getName());
        }
        return answer;
    }

}