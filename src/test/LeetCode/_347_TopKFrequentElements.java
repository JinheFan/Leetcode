package test.LeetCode;

import java.util.*;

public class _347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> (b.getValue() - a.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        while(!pq.isEmpty() && k-- > 0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        return res;
    }
    public List<Integer> topKFrequent2(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : map.keySet()){
            int frequent = map.get(num);
            if(bucket[frequent] == null){
                bucket[frequent] = new LinkedList<>();
            }
            bucket[frequent].add(num);
        }
        for(int i = bucket.length - 1; i >= 0 && res.size() < k; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
