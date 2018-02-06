package graphAndTrees;

import java.util.*;

public class LevelOrderTraversalBottom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return result;
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<Integer> res = new ArrayList<Integer>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                res.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(res);
        }
        Collections.reverse(result);
        return result;
    }
}
