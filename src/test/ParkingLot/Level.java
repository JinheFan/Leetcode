package test.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<ParkingSpot> spots;
    private int currentLevelAvailableSpots;
    private int rows;
    private int cols;
    private int SpotId;
    private int index;

    public Level(int rows, int cols) {
        this.spots = new ArrayList<>();
        this.rows = rows;
        this.cols = cols;
        this.index = 0;
        for (int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols / 4; j++){
                spots.add(new ParkingSpot());
            }
        }
    }

    public int getCurrentLevelAvailableSpots(){
        return currentLevelAvailableSpots;
    }


}
