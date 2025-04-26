//----------------------------------------------------------------------------------------------------------------------
//PART2
//-----------------------------------------------------------------------------------------------------------------------
package Part2;

//Abstract class representing an aircraft

public abstract class Aircraft {
    protected String id;
    protected int fuelLevel;

    public Aircraft(String id, int fuelLevel) {
        this.id = id;
        this.fuelLevel = fuelLevel;
    }

    public abstract void receive(String msg);

    public void send(String msg, TowerMediator mediator) {
        mediator.broadcast(msg, this);
    }

    public String getId() {
        return id;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }
}
