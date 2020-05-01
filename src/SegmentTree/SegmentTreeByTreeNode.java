package SegmentTree;

public class SegmentTreeByTreeNode {
    SegmentTreeNode root;
    public SegmentTreeByTreeNode(int[] nums){
        root = buildTree(nums, 0, nums.length - 1);
    }

    public SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        SegmentTreeNode cur = new SegmentTreeNode(start, end);
        if(start == end){
            cur.sum = nums[start];
        }else{
            int mid = (end - start) / 2 + start;
            cur.left = buildTree(nums, start, mid);
            cur.right = buildTree(nums, mid + 1, end);
            cur.sum = cur.left.sum + cur.right.sum;
        }
        return cur;
    }

    public void update(int i, int val){
        update(root, i, val);
    }

    private void update(SegmentTreeNode cur, int pos, int val){
        if(cur.start == cur.end){
            cur.sum = val;
            return;
        }
        int mid = (cur.end - cur.start) / 2 + cur.start;
        if(pos <= mid){
            update(cur.left, pos, val);
        }else{
            update(cur.right, pos, val);
        }
        cur.sum = cur.left.sum + cur.right.sum;
    }

    public int sumRange(int i, int j){
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode cur, int start, int end){
        if(cur.start == start && cur.end == end){
            return cur.sum;
        }
        int mid = (cur.end - cur.start) / 2 + cur.start;
        if(end <= mid){
            return sumRange(cur.left, start, end);
        }else if(start >= mid + 1){
            return sumRange(cur.right, start, end);
        }else {
            return sumRange(cur.left, start, end) + sumRange(cur.right, start, end);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4, 5};
        SegmentTreeByTreeNode segment = new SegmentTreeByTreeNode(num);
        System.out.println(segment.sumRange(1, 3));
    }
}
