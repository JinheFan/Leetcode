package test.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;
    private int totalAvailableSpots;

    public int getTotalAvailableSpots(){
        for (int i = 0; i < levels.size(); i++){
            totalAvailableSpots += levels.get(i).getCurrentLevelAvailableSpots();
        }
        return totalAvailableSpots;
    }

    public List<ParkingSpot> findAvailableSpots(Vehicle vehicle){
        List<ParkingSpot> list = new ArrayList<>();
        if (vehicle.size == VehicleSize.Compact){

        }else if(vehicle.size == VehicleSize.MotorCycle){

        }else if(vehicle.size == VehicleSize.Large){

        }
        return list;
    }
}
