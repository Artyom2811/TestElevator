import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Elevator {

    int height = 0;
    int numberOfActions = 0;
    boolean stopButton = false;
    List<СommandForElevator> listPanelElevator = new LinkedList<>();

    //Метод запуска который возвращает конечную высоту лифта и количество произведенных действий лифта
    public int[] start() {
        while (listPanelElevator.size() != 0) {
            execution();
        }
        return new int[]{height, numberOfActions};
    }

    //Метод выполнения комманд
    private void execution() {
        ArrayList<Integer> route = createRoute();
        move(route);
    }

    //Метод составления маршрута
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

    //Метод выполнения действий
    private void move(ArrayList<Integer> route) {
        for (Integer el : route) {
            System.err.println("Лифт едет на " + el + " этаж");
            int needFloor = (el - 1) * 4;
            try {
                if (this.height > el) {
                    for (int i = this.height; i != needFloor; i--) {
                        while (stopButton) {
                            System.err.println("Лифт стоит по кнопке стоп");
                            numberOfActions++;
                            Thread.sleep(1000);
                        }
                        Thread.sleep(1000);
                        this.height--;
                        numberOfActions++;
                    }

                } else {
                    for (int i = this.height; i != needFloor; i++) {
                        while (stopButton) {
                            numberOfActions++;
                            Thread.sleep(1000);
                        }
                        Thread.sleep(1000);
                        this.height++;
                        numberOfActions++;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("Лифт на " + el + " этаже");
        }
    }

    //Метод поиска попутчиков
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

    //Метод нажатия на кнопку Стоп
    private void pressStopButton() {
        if (stopButton) {
            stopButton = false;
        } else {
            stopButton = true;
        }
    }
}