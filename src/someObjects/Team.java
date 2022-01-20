package someObjects;

import exceptions.EmptyDataException;
import exceptions.InvalidDataException;
import people.Shorty;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Shorty> shorties;

    public Team(List<Shorty> shorties) throws EmptyDataException, NullPointerException {
        if (shorties == null) {
            throw new NullPointerException("List can't be null");
        }
        if (shorties.isEmpty()) {
            throw new EmptyDataException("your list can't be empty");
        }
        this.shorties = shorties;
    }

    public List<Shorty> getShorties() {
        return shorties;
    }

    public Shorty getShorty(int index) throws InvalidDataException {
        if (index < 0) {
            throw new InvalidDataException("wrong index");
        }
        return shorties.get(index);
    }

    @Override
    public String toString() {
        return "Team{" +
                "shorties=" + shorties +
                '}';
    }
}
