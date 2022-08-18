package JZ.二叉树;

import java.util.*;

/**
 * @author Green写代码
 * @date 2022-08-17 13:04
 */
public class JZ32_3 {
    class TreeNode {
        int val;
        JZ32.TreeNode left;
        JZ32.TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean rol = true;//0表示正常，如果是1就表示反着
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty()){
            int length = q.size();
            LinkedList<Integer> path = new LinkedList<>();
            for(int i = 0; i < length; i++) {
                TreeNode node = q.poll();
                if(rol == true)
                    path.addLast(node.val);
                else
                    path.addFirst(node.val);
//                if(node.left != null) q.offer(node.left);
//                if(node.right != null) q.offer(node.right);

            }
            res.add(path);
            rol = !rol;
        }
        return res;
    }
}
