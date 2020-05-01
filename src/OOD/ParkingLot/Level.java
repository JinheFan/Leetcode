package OOD.ParkingLot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availabelSpots = 0;
    private int SPOTS_PER_ROW;
    private int num_rows;

    public Level(int floor, int SPOTS_PER_ROW, int num_rows) {
        this.floor = floor;
        this.SPOTS_PER_ROW = SPOTS_PER_ROW;
        int numberSpots = 0;
        spots = new ParkingSpot[num_rows * SPOTS_PER_ROW];

        for (int row = 0; row < num_rows; row++) {
            for (int spot = 0; spot < SPOTS_PER_ROW / 4; spot++) {
                VehicleSize vehicleSize = VehicleSize.Motorcycle;
                spots[numberSpots++] = new ParkingSpot(vehicleSize, row, numberSpots, this);
            }
            for (int spot = SPOTS_PER_ROW / 4; spot < SPOTS_PER_ROW / 4 * 3; spot++) {
                VehicleSize vehicleSize = VehicleSize.Compact;
                spots[numberSpots++] = new ParkingSpot(vehicleSize, row, numberSpots, this);
            }
            for (int spot = SPOTS_PER_ROW / 4 * 3; spot < SPOTS_PER_ROW; spot++) {
                VehicleSize vehicleSize = VehicleSize.Large;
                spots[numberSpots++] = new ParkingSpot(vehicleSize, row, numberSpots, this);
            }
        }
        availabelSpots = numberSpots;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(availabelSpots < vehicle.getSpotsNeeded()){
            return  false;
        }
        int spotNumber = findAvailableSpots(vehicle);
        if(spotNumber < 0){
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    private int findAvailableSpots(Vehicle vehicle){
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for (int i = 0; i < spots.length; i++){
            ParkingSpot spot = spots[i];
            if(lastRow != spot.getRow()){
                lastRow = spot.getRow();
            }
            if(spot.canFitVehicle(vehicle)){
                spotsFound++;
            }else{
                spotsFound = 0;
            }
            if(spotsFound == spotsNeeded){
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }

    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle){
        vehicle.clearSpots();
        boolean success = true;
        for(int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++){
            success &= spots[i].park(vehicle);
        }
        availabelSpots -= vehicle.spotsNeeded;
        return success;
    }
    public void spotFreed(){
        availabelSpots++;
    }
    public int availableSpots(){
        return availabelSpots;
    }
    public void print(){
        int lastRow = -1;
        for (int i = 0; i < spots.length; i++){
            ParkingSpot spot = spots[i];
            if(spot.getRow() != lastRow){
                System.out.println(" ");
                lastRow = spot.getRow();
            }
            spot.print();
        }
    }
}
