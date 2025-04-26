//----------------------------------------------------------------------------------------------------------------------
//PART2
//-----------------------------------------------------------------------------------------------------------------------
package Part2;

// interface that manages communications and access to the runway

public interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestRunway(Aircraft a);
}
