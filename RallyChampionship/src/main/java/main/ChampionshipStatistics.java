package main;

import java.util.HashMap;
import java.util.Map;

// static method -> dont need to create Championstats object

// SRP -> this file only calculates

public class ChampionshipStatistics {

    public static double averagePointsPerDriver(ChampionshipManager manager){
        int total = 0;

        for(Driver x: manager.getDrivers()){
            total+= x.getPoints();
        }
        return (double) total/manager.getDrivers().size();
    }

    public static String mostSuccessfulCountry(ChampionshipManager manager){

        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver x: manager.getDrivers()){
            countryPoints.put( 
                x.getCountry(),
                countryPoints.getOrDefault(x.getCountry(),0) + x.getPoints()
            );
        }

        String bestCountry = "";
        int max = 0;

        for (String country : countryPoints.keySet()) {
            if (countryPoints.get(country) > max) {
                max = countryPoints.get(country);
                bestCountry = country;
            }
        }

        return bestCountry;
    }

    public static int totalRace(ChampionshipManager manager){
        return manager.getRaces().size();
    }
    
}
