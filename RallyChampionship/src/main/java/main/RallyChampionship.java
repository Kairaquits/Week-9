package main;

import java.util.*;

public class RallyChampionship {

    public static void main(String[] args) {

        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelCar = new GravelCar("Toyota", "XYZ", 400, 100);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "YYZ", 300, 180);

        Driver d1 = new Driver("Sébastien Ogier", "France", gravelCar);
        Driver d2 = new Driver("Kalle Rovanperä", "Finland", asphaltCar);
        Driver d3 = new Driver("Ott Tänak", "Estonia", gravelCar);
        Driver d4 = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        manager.registerDriver(d1);
        manager.registerDriver(d2);
        manager.registerDriver(d3);
        manager.registerDriver(d4);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");

        race1.recordResult(d1, 1, 25);
        race1.recordResult(d3, 2, 18);
        race1.recordResult(d2, 3, 15);
        race1.recordResult(d4, 4, 12);

        manager.addRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");

        race2.recordResult(d2, 1, 25);
        race2.recordResult(d4, 2, 18);
        race2.recordResult(d1, 3, 15);
        race2.recordResult(d3, 4, 12);

        manager.addRaceResult(race2);

        System.out.println("===== STANDINGS =====");

        int rank = 1;

        for (Driver x : manager.getStandings()) {
            System.out.println(rank + ". " + x.getName() + " (" + x.getCountry() + "): " + x.getPoints() + " points");
            rank++;
        }
        System.out.println();

        System.out.println("===== CHAMPIONSHIP LEADER =====");
        Driver leader = manager.getLeader();
        System.out.println(leader.getName() + " with " + leader.getPoints() + " points");
        System.out.println();

        System.out.println("===== CHAMPIONSHIP STATISTICS =====");

        int totalDrivers = manager.getDrivers().size();
        int totalRaces = ChampionshipStatistics.totalRace(manager);

        double avg = ChampionshipStatistics.averagePointsPerDriver(manager);
        String avgFormatted = String.format(Locale.GERMAN, "%.2f", avg);

        int totalPoints = 0;
        for (Driver x : manager.getDrivers()) {
            totalPoints += x.getPoints();
        }

        System.out.println("Total Drivers: " + totalDrivers);
        System.out.println("Total Races: " + totalRaces);
        System.out.println("Average Points Per Driver: " + avgFormatted);
        System.out.println("Most Successful Country: " + ChampionshipStatistics.mostSuccessfulCountry(manager));
        System.out.println("Total Championship Points: " + totalPoints);
        System.out.println();

        System.out.println("===== RACE RESULTS =====");

        for (RallyRaceResult race : manager.getRaces()) {

            System.out.println("----- Race: " + race.getRaceName() + " (" + race.getLocation() + ") -----");

            int position = 1;

            for (Driver driver : race.getResults()) {
                System.out.println("Position " + position + ": " + driver.getName() + " - " + race.getDriverPoints(driver) + " points");
                position++;
            }

            System.out.println();
        }

        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}

