import org.junit.jupiter.api.Test;


public class ElevatorTest {
    @Test
    public void testPut() {
        Elevator elevator = new Elevator();
        elevator.listPanelElevator.add(new СommandForElevator(1, 4));
        elevator.listPanelElevator.add(new СommandForElevator(3, 2));
        elevator.listPanelElevator.add(new СommandForElevator(4, 1));
        elevator.start();
    }
}