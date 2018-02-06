package graphAndTrees;

import java.util.*;

public class RootToLeafPaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<String>();
        if(root != null)
            traverse(root, "", path);
        return path;
    }
    
    public void traverse(TreeNode root, String path, List<String> finalPath) {
        if(root.left == null && root.right == null)
            finalPath.add(path + root.val);
        if(root.left != null)
            traverse(root.left, path + root.val + "->", finalPath);
        if(root.right != null)
            traverse(root.right, path + root.val + "->", finalPath);
    }
}
