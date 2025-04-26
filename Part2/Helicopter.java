//----------------------------------------------------------------------------------------------------------------------
//PART2
//-----------------------------------------------------------------------------------------------------------------------
package Part2;

//Helicopter

public class Helicopter extends Aircraft {
    public Helicopter(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("| Helicopter " + id + " received | " + msg);
    }
}
