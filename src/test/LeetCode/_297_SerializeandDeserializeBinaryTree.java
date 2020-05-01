package test.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _297_SerializeandDeserializeBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root){
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                stringBuilder.append("null ");
                continue;
            }
            stringBuilder.append(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return stringBuilder.toString();
    }

    public TreeNode deserialize(String string){
        if(string.length() == 0){
            return null;
        }
        String[] strings = string.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i = 1; i < strings.length; i++){
            TreeNode cur = queue.poll();
            if(!strings[i].equals("null")){
                cur.left = new TreeNode(Integer.valueOf(strings[i]));
                queue.offer(cur.left);
            }
            if(!strings[++i].equals("null")){
                cur.right = new TreeNode(Integer.valueOf(strings[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
