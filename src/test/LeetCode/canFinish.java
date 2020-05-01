package test.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class canFinish {
    public void finish(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int k = 0;
        int[] res = new int[numCourses];

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                res[k++] = i;
            }
        }

        while(!queue.isEmpty()){
            int pre = queue.poll();
            for(int[] prerequisite : prerequisites){
                if(prerequisite[1] == pre){
                    indegree[prerequisite[0]]--;
                    if(indegree[prerequisite[0]] == 0){
                        queue.offer(prerequisite[0]);
                        res[k++] = prerequisite[0];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] {
                {1, 0},
                {2, 1}
        };
        canFinish finish = new canFinish();
        finish.finish(3, prerequisites);
    }
}
