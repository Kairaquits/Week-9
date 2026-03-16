package main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//SINGLETON: class where only one object exists.
// We only want one Championship Manager.

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();

    private ChampionshipManager() {}

    // Get instance -> every part of the program asks class for THE manager, doesnt create own. 
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRaceResult(RallyRaceResult race) {
        races.add(race);
    }

    public List<Driver> getStandings() {
        drivers.sort(Comparator.comparingInt(Driver::getPoints).reversed());
        return drivers;
    }

    public Driver getLeader() {
        return getStandings().get(0);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RallyRaceResult> getRaces() {
        return races;
    }
}