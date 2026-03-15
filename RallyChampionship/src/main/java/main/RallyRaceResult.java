package main;

import java.util.*;

public class RallyRaceResult implements RaceResult {

    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        results = new LinkedHashMap<>();
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    public int getDriverPoints(Driver driver) {
        if (results.containsKey(driver)) {
            return results.get(driver);
        }
        return 0;
    }

    public List<Driver> getResults() {
        return new ArrayList<>(results.keySet());
    }
}