package Google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Example 1:
 *
 *
 *
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: [1,0]
 * Explanation:
 * Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
 * Example 2:
 *
 *
 *
 * Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * Output: [0,2,1]
 * Explanation:
 * Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
 * */
public class _1057_CampusBike {
    class node{
        int dist;
        int worker;
        int bike;
        public node(int dist, int worker, int bike){
            this.dist = dist;
            this.worker = worker;
            this.bike = bike;
        }
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] ans = new int[workers.length];
        Arrays.fill(ans,-1);
        boolean[] used = new boolean[bikes.length];
        int cnt = 0;
        PriorityQueue<node> heap = new PriorityQueue<node>(new Comparator<node>(){
            @Override
            public int compare(node o1, node o2){
                if(o1.dist == o2.dist){
                    if(o1.worker == o2.worker){     //two bikes, one worker
                        return o1.bike - o2.bike;
                    }
                    return o1.worker - o2.worker;       //two workers, one bike
                }else{
                    return o1.dist - o2.dist;
                }
            }
        });


        for(int i = 0; i < workers.length; i++){
            for(int j = 0; j < bikes.length; j++){
                int dist = calDist(workers[i],bikes[j]);
                node n = new node(dist,i,j);
                heap.offer(n);
            }
        }
        while(cnt != workers.length){
            node cur = heap.poll();
            int index = cur.worker;
            int bike = cur.bike;
            if(ans[index] == -1 && !used[bike]){
                ans[index] = bike;
                used[bike] = true;
                cnt++;
            }
        }
        return ans;

    }
    public int calDist(int[] worker, int[] bikes){
        return Math.abs(worker[0] - bikes[0]) + Math.abs(worker[1] - bikes[1]);
    }
}
