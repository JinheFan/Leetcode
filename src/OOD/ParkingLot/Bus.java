package OOD.ParkingLot;

public class Bus extends Vehicle {
    public Bus(){
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }

    @Override
    public void print() {
        System.out.println("Bus");
    }
}
