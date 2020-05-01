package test.ParkingLot;

public class ParkingSpot {
    private boolean available;

    public boolean isAvailable(){
        return available;
    }

    public void takeSpot(){
        this.available = false;
    }

    public void leaveSpot(){
        this.available = true;
    }
}
