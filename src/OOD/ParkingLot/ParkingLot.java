package OOD.ParkingLot;

public class ParkingLot {
    private Level[] levels;
    private int NUM_LEVELS;
    private int SPOTS_PER_ROW;

    public ParkingLot(Level[] levels, int NUM_LEVELS, int SPOTS_PER_ROW) {
        this.levels = levels;
        this.NUM_LEVELS = NUM_LEVELS;
        this.SPOTS_PER_ROW = SPOTS_PER_ROW;
        for (int i = 0; i < NUM_LEVELS; i++){
            levels[i] = new Level(i, SPOTS_PER_ROW, NUM_LEVELS);
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for (int i = 0; i < levels.length; i++){
            if (levels[i].parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void unParkVehicle(Vehicle vehicle){
        vehicle.clearSpots();
    }

    public void print(){
        for (int i = 0; i < levels.length; i++){
            System.out.println("Level" + i + ":");
            levels[i].print();
            System.out.println();
        }
        System.out.println();
    }
}
