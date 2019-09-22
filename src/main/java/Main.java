

public class Main {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.listPanelElevator.add(new СommandFromPanelFloor(1, 4));
        elevator.listPanelElevator.add(new СommandFromPanelFloor(3, 2));
        elevator.listPanelElevator.add(new СommandFromPanelFloor(4, 1));
        elevator.start();
    }
}
