package OOD.ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle {
    protected VehicleSize size;
    protected String licensePlate;
    protected int spotsNeeded;
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    public int getSpotsNeeded(){
        return spotsNeeded;
    }
    public VehicleSize getSize(){
        return size;
    }
    public void parkInSpot(ParkingSpot spot){
        parkingSpots.add(spot);
    }
    public void clearSpots(){
        for(int i = 0; i < parkingSpots.size(); i++){
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }
    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print();
}
