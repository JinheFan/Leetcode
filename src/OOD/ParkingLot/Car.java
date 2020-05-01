package OOD.ParkingLot;

public class Car extends Vehicle {
    public Car(){
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }

    @Override
    public void print() {
        System.out.println("Car");
    }
}
