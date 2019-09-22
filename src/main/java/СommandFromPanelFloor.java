public class СommandFromPanelFloor {
    public int numberFloorPosition;
    public int numberFloorRequired;

    public СommandFromPanelFloor(int numberFloorPosition, int numberFloorRequired) {
        this.numberFloorPosition = numberFloorPosition;
        this.numberFloorRequired = numberFloorRequired;
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
