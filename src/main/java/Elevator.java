import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Elevator {

    int height = 0;
    boolean stopButton = false;
    List<СommandForElevator> listPanelElevator = new LinkedList<СommandForElevator>();

    public void start() {
        while (true) {
            if (listPanelElevator.size() != 0) {
                execution();
            }
        }
    }

    private void execution() {
        ArrayList<Integer> route = createRoute();
        move(route);
    }

    private ArrayList<Integer> createRoute() {
        int startFloor = listPanelElevator.get(0).numberFloorPosition;
        int finishFloor = listPanelElevator.get(0).numberFloorRequired;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(startFloor);
        list.add(finishFloor);
        listPanelElevator.remove(0);
        searchForTravelCompanions(startFloor, finishFloor, list);
        return list;
    }

    private void move(ArrayList<Integer> route) {
        for (Integer el : route) {
            System.err.println("Лифт едет на " + el + " этаж");
            int needFloor = (el - 1) * 4;
            if (this.height > el) {
                if (!stopButton) {
                    for (int i = this.height; i != needFloor; i--) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        this.height--;
                    }
                }
            } else if (!stopButton) {
                for (int i = this.height; i != needFloor; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.height++;
                }
            }
            System.err.println("Лифт на " + el + " этаже");
        }
    }

    private void searchForTravelCompanions(int startFloor, int finishFloor, ArrayList<Integer> list) {
        //Если лифт едет вниз
        if (startFloor > finishFloor) {
            for (СommandForElevator el : listPanelElevator) {
                if (el.numberFloorPosition <= startFloor && el.numberFloorRequired >= finishFloor && el.direction.equals("DOWN")) {
                    list.add(finishFloor);
                    listPanelElevator.remove(el);
                }
            }
            //Если лифт едет вверх
        } else {
            for (СommandForElevator el : listPanelElevator) {
                if (el.numberFloorPosition >= startFloor && el.numberFloorRequired <= finishFloor && el.direction.equals("UP")) {
                    list.add(finishFloor);
                    listPanelElevator.remove(el);
                }
            }
        }

    }

    private void pressStopButton() {
        if (stopButton) {
            stopButton = false;
        } else {
            stopButton = true;
        }
    }
}