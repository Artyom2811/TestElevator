public class СommandForElevator {
    public int numberFloorPosition;
    public int numberFloorRequired;
    public String direction;

    public СommandForElevator(int numberFloorPosition, int numberFloorRequired) {
        this.numberFloorPosition = numberFloorPosition;
        this.numberFloorRequired = numberFloorRequired;
        if(numberFloorPosition<numberFloorRequired){
            this.direction = "UP";
        }else this.direction = "DOWN";
    }

    public int getNumberFloorPosition() {
        return numberFloorPosition;
    }

    public void setNumberFloorPosition(int numberFloorPosition) {
        this.numberFloorPosition = numberFloorPosition;
    }

    public int getNumberFloorRequired() {
        return numberFloorRequired;
    }

    public void setNumberFloorRequired(int numberFloorRequired) {
        this.numberFloorRequired = numberFloorRequired;
    }
}
