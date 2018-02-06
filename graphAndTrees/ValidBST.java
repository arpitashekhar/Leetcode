package graphAndTrees;
class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
public class ValidBST {
	public boolean isValidBST(TreeNode root) {
        return validBinaryTree(root, null, null);
    }
    
    public boolean validBinaryTree(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
         
        return (min == null || root.val > min) && (max == null || root.val < max) && 
        		validBinaryTree(root.left, min, root.val) && validBinaryTree(root.right, root.val, max);
    }
    
    // Iterative
    
    /*public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
 
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while(!queue.isEmpty()){
            BNode b = queue.poll();
            if(b.n.val <= b.left || b.n.val >=b.right){
                return false;
            }
            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.val));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.val, b.right));
            }
        }
        return true;
    }
    class BNode{
	    TreeNode n;
	    double left;
	    double right;
	    public BNode(TreeNode n, double left, double right){
	        this.n = n;
	        this.left = left;
	        this.right = right;
	    }
	}
    */
}
