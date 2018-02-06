package graphAndTrees;

public class DiameterOfTree {
	public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int lheight = height(root.left);
        int rheight = height(root.right);
        
        int ldiameter = diameterOfBinaryTree(root.left);
        int rdiameter = diameterOfBinaryTree(root.right);
        
        return Math.max((lheight + rheight), Math.max(ldiameter, rdiameter));
    }
    
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
