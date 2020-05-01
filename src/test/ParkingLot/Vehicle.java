package test.ParkingLot;

public abstract class Vehicle {
    protected VehicleSize size;
    protected int spotsNeeded;
    protected String liscensePlate;

    public Vehicle(VehicleSize size, int spotsNeeded){
        this.size = size;
        this.spotsNeeded = spotsNeeded;
    }

    public  VehicleSize getVehicleSize(){
        return size;
    }

    public int getSpotsNeeded(){
        return spotsNeeded;
    }
}
