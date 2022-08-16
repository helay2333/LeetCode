package JZ.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Green写代码
 * @date 2022-08-16 15:25
 */
public class JZ32 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
    }
    public int[] levelOrder(TreeNode root) {
        int [] res = new int[0];
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                arrayList.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        res = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++){
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
