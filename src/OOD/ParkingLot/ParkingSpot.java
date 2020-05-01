package OOD.ParkingLot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(VehicleSize spotSize, int row, int spotNumber, Level level) {
        this.spotSize = spotSize;
        this.row = row;
        this.spotNumber = spotNumber;
        this.level = level;
    }
    public boolean isAvailable(){
        return vehicle == null;
    }
    public boolean canFitVehicle(Vehicle vehicle){
        return isAvailable() && vehicle.canFitInSpot(this);
    }
    public boolean park(Vehicle vehicle){
        if(!canFitVehicle(vehicle)){
            return false;
        }
        this.vehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }
    public void removeVehicle(){
        level.spotFreed();
        vehicle = null;
    }
    public int getRow(){
        return row;
    }
    public int getSpotNumber(){
        return spotNumber;
    }
    public VehicleSize getSize(){
        return spotSize;
    }
    public void print(){
        if(vehicle == null){
            if(spotSize == VehicleSize.Compact){
                System.out.println("Car");
            }else if(spotSize == VehicleSize.Motorcycle){
                System.out.println("Motorcycle");
            }else if(spotSize == VehicleSize.Large){
                System.out.println("Large");
            }
        }else{
            vehicle.print();
        }
    }
}
