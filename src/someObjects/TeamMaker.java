package someObjects;

import ecxeptions.EmptyDataException;
import people.Shorty;

import java.util.ArrayList;
import java.util.List;

public class TeamMaker {
    public List<Shorty> makeGroup(Shorty... shorties) throws EmptyDataException {
        List<Shorty> group = new ArrayList<>();
        for (Shorty shorty : shorties) {
            if (shorty == null) {
                throw new EmptyDataException("Shorty can't be null");
            } else {
                group.add(shorty);
            }
        }
        System.out.printf("\nOur powerful team of %d people is ready for adventures!\n", group.size());
        return group;
    }

    public List<Shorty> divideTeam(List<Shorty> group, Shorty... shorties) throws EmptyDataException {
        List<Shorty> newGroup = new ArrayList<>();
        if (shorties == null || group == null) {
            throw new EmptyDataException("You should give me some shorties in this method");
        } else {
            for (Shorty shorty : shorties) {
                if (shorty == null) {
                    throw new EmptyDataException("Shorty can't be null");
                } else {
                    for (Shorty shortyList : group) {
                        if (shortyList == null) {
                            throw new EmptyDataException("Shorty can't be null");
                        } else {
                            if (shortyList.getClass() == shorty.getClass()) {
                                newGroup.add(shorty);
                            }
                        }

                    }
                }
            }
            group.removeAll(newGroup);
        }
        System.out.println("Our shorties decided to divide group! \n\nThe first group:");
        for (Shorty sh :
                newGroup) {
            System.out.println(sh.getName());
        }
        System.out.println("\nThe second group:");
        for (Shorty sh :
                group) {
            System.out.println(sh.getName());
        }
        return newGroup;
    }
}
