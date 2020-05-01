package Heap.MaxHeap;
// Time : O(nlogn)
import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] nums){
        for(int i = (nums.length - 2) / 2; i >= 0; i--){  // nums.length - 1 是最后一个元素， 再减1 是为了取parent Index
            heapAdjust(nums, i, nums.length);
        }

        for(int i = nums.length - 1; i > 0; i--){
            swap(nums, 0, i);
            heapAdjust(nums, 0, i);
        }
    }

    private static void heapAdjust(int[] nums, int parentIndex, int length){
        while(parentIndex * 2 + 1 < length){
            int biggerIndex = parentIndex * 2 + 1;
            if(parentIndex * 2 + 2 < length && nums[parentIndex * 2 + 1] < nums[parentIndex * 2 + 2]){
                biggerIndex = parentIndex * 2 + 2;
            }
            if(nums[parentIndex] < nums[biggerIndex]){
                swap(nums, parentIndex, biggerIndex);
            }else{
                break;
            }
            parentIndex = biggerIndex;
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 4, 7, 9, 49, 8};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
