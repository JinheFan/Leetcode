package Tree.BSTImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTImpl {
    public int size;

    private TreeNode root;

    public BSTImpl() {
        super();
        this.size = 0;
        this.root = null;
    }

    public void add(int val) {
        root = add(root, val);
    }

    private TreeNode add(TreeNode node, int val) {
        if(node == null) {
            size++;
            return new TreeNode(val);
        }
        if(node.val == val) {
            throw new IllegalArgumentException("node exists");
        }
        if(node.val > val) {
            node.left = add(node.left, val);
        }else {
            node.right = add(node.right, val);
        }
        return node;
    }

    public void delete(int val) {
        delete(root, val);
    }

    public TreeNode delete(TreeNode cur, int val) {
        if(cur == null) {
            return null;
        }
        if(cur.val < val) {
            delete(cur.right, val);
        }else if(cur.val > val) {
            delete(cur.left, val);
        }else {
            if(cur.left == null) {
                size--;
                return cur.right;
            }else if(cur.right == null) {
                size--;
                return  cur.left;
            }else {
                TreeNode minNode = findMin(cur.right);
                cur.val = minNode.val;
                cur.right = delete(cur.right, cur.val);
                size--;
            }
        }
        return cur;

    }

    public TreeNode findMin(TreeNode cur) {
        while(cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(TreeNode root, int val) {
        if(root == null) {
            return false;
        }

        if(root.val == val) {
            return true;
        }

        if(root.val < val) {
            return contains(root.right, val);
        }

        if(root.val > val) {
            return contains(root.left, val);
        }
        return false;
    }

    public int Size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        for(int num : list) {
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        BSTImpl bstImpl = new BSTImpl();
        bstImpl.add(1);
        bstImpl.add(5);
        bstImpl.add(4);
        bstImpl.add(3);
        bstImpl.add(2);

        bstImpl.print();
    }
}
