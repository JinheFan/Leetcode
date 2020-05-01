package Topology;

import java.util.LinkedList;
import java.util.Queue;

public class _207_CanFinish {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int k = 0;
        int[] indegree = new int[numCourses];
        for(int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
                k++;
            }
        }

        while(!queue.isEmpty()) {
            int pre = queue.poll();
            for(int[] pair : prerequisites) {
                if(pair[1] == pre) {
                    indegree[pair[0]]--;
                    if(indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        k++;
                    }
                }
            }
        }
        return k == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] {
                {1, 0},
                {2, 1}
        };
        System.out.println(canFinish(3, prerequisites));
    }
}
