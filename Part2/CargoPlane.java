//----------------------------------------------------------------------------------------------------------------------
//PART2
//----------------------------------------------------------------------------------------------------------------------
package Part2;

//Cargo Plane

public class CargoPlane extends Aircraft {
    public CargoPlane(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("| Cargo " + id + " received | " + msg);
    }
}

