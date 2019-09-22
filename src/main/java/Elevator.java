import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Elevator {

    int height = 0;
    List<СommandFromPanelFloor> listPanelElevator = new LinkedList<СommandFromPanelFloor>();

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
        // TODO: 22.09.2019 Довавить проверку и добавление попутчиков 
        return list;
    }

    private void move(ArrayList<Integer> route) {
        for (Integer el : route) {
            int needFloor = (el - 1) * 4;
            if (this.height > el) {
                for (int i = this.height; i != needFloor; i--) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.height--;
                    System.err.println("Лифт проехал 1м вниз");
                }

            } else for (int i = this.height; i != needFloor; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.height++;
                System.err.println("Лифт проехал 1м вверх");
            }
            System.err.println("Лифт на " + el + " этаже");
        }

        //Страрй вариант
//        if (this.height > height) {
//            for (int i = this.height; i != height; i--) {
//
//            }
//        } else for (int i = this.height; i != height; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            this.height++;
//            System.err.println("Лифт проехал 1м");
//        }
//        System.err.println("Лифт прибыл на " + height / 4 + " этаж");
//        listPanelElevator.remove(0);
    }
}