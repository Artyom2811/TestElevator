import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ElevatorTest {

    //Тестовые данные которые были в задании
    @Test
    public void testFromTask() {
        Elevator elevator = new Elevator();
        elevator.listPanelElevator.add(new СommandForElevator(1, 4));
        elevator.listPanelElevator.add(new СommandForElevator(3, 2));
        elevator.listPanelElevator.add(new СommandForElevator(4, 1));
        int[] result = elevator.start();
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(40, result[1]);
    }

    @Test
    public void testWithoutCommand() {
        Elevator elevator = new Elevator();
        int[] result = elevator.start();
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(0, result[1]);
    }

    @Test
    public void testMoveToUp() {
        Elevator elevator = new Elevator();
        elevator.listPanelElevator.add(new СommandForElevator(1, 4));
        int[] result = elevator.start();
        Assertions.assertEquals(12, result[0]);
        Assertions.assertEquals(12, result[1]);
    }

    @Test
    public void testMoveToDown() {
        Elevator elevator = new Elevator();
        elevator.listPanelElevator.add(new СommandForElevator(4, 1));
        int[] result = elevator.start();
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(24, result[1]);
    }


}