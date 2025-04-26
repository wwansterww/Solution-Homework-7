//----------------------------------------------------------------------------------------------------------------------
//PART2
//-----------------------------------------------------------------------------------------------------------------------
package Part2;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

//Concrete mediator that manages runway access and communication

public class ControlTower implements TowerMediator {
    private final Queue<Aircraft> landingQueue = new ConcurrentLinkedQueue<>();
    private final Queue<Aircraft> takeOffQueue = new ConcurrentLinkedQueue<>();
    private final List<Aircraft> aircraftList = new ArrayList<>();
    private boolean runwayAvailable = true;

    public void registerAircraft(Aircraft a) {
        aircraftList.add(a);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if (msg.equalsIgnoreCase("MAYDAY")) {
            System.out.println("| TOWER | Emergency from " + sender.getId() + "! Clearing runway immediately!");
            runwayAvailable = true;
            landingQueue.add(sender);
            notifyAllHold(sender);
        } else {
            System.out.println("| " + sender.getId() + " | " + msg);
        }
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (a.getFuelLevel() < 10) {
            landingQueue.add(a);
            System.out.println("| TOWER | " + a.getId() + " low fuel! Prioritizing landing.");
            return true;
        }
        if (runwayAvailable) {
            runwayAvailable = false;
            System.out.println("| TOWER | " + a.getId() + " granted immediate runway access.");
            return true;
        } else {
            if (a instanceof PassengerPlane || a instanceof CargoPlane) {
                landingQueue.add(a);
            } else {
                takeOffQueue.add(a);
            }
            System.out.println("| TOWER | " + a.getId() + " added to queue.");
            return false;
        }
    }

    private void notifyAllHold(Aircraft except) {
        for (Aircraft a : aircraftList) {
            if (!a.equals(except)) {
                a.receive("Hold position. Emergency in progress.");
            }
        }
    }

    public void processNext() {
        if (!landingQueue.isEmpty()) {
            Aircraft a = landingQueue.poll();
            System.out.println("| TOWER | " + a.getId() + " is landing.");
            runwayAvailable = false;
        } else if (!takeOffQueue.isEmpty()) {
            Aircraft a = takeOffQueue.poll();
            System.out.println("| TOWER | " + a.getId() + " is taking off.");
            runwayAvailable = false;
        } else {
            runwayAvailable = true;
        }
    }
}