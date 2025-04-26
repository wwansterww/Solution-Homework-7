//----------------------------------------------------------------------------------------------------------------------
//PART2
//-----------------------------------------------------------------------------------------------------------------------
package Part2;

import java.util.*;
import java.util.concurrent.*;

//Main driver that generates random aircraft and simulates requests

public class SimulationDriver {
    public static void main(String[] args) {
        Part2.ControlTower tower = new Part2.ControlTower();
        Random random = new Random();
        List<Aircraft> aircraftList = new ArrayList<>();

        // Create 10 random aircraft
        for (int i = 1; i <= 10; i++) {
            int fuel = random.nextInt(100);
            Aircraft a;
            int type = random.nextInt(3);
            if (type == 0) {
                a = new Part2.PassengerPlane("Passenger" + i, fuel);
            } else if (type == 1) {
                a = new CargoPlane("Cargo" + i, fuel);
            } else {
                a = new Part2.Helicopter("Helicopter" + i, fuel);
            }
            aircraftList.add(a);
            tower.registerAircraft(a);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Automatically stop the simulation after 30 seconds
        scheduler.schedule(() -> {
            System.out.println(">>> Simulation finished.");
            scheduler.shutdown();
        }, 30, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            if (!aircraftList.isEmpty()) {
                Aircraft a = aircraftList.get(random.nextInt(aircraftList.size()));
                if (a.getFuelLevel() < 5) {
                    a.send("MAYDAY", tower);
                } else {
                    tower.requestRunway(a);
                }
                tower.processNext();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}
