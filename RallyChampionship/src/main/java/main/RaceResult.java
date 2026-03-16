package main;

// Interface segregation -> interface is small enough to make sure that classes use their needed methods. 

import java.util.List;

public interface RaceResult {

    void recordResult(Driver driver, int position, int points);

    int getDriverPoints(Driver driver);

    List<Driver> getResults();
}