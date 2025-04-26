//----------------------------------------------------------------------------------------------------------------------
//PART2
//-----------------------------------------------------------------------------------------------------------------------
package Part2;

//Passenger Plane

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("| Passenger " + id + " received | " + msg);
    }
}
