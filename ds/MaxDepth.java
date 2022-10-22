package ds;

public class MaxDepth {
    private int currentDepth = 0;
    private int maxDepth = 0;

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        currentDepth++;
        System.out.println("before visiting node value:" + root.getNodeValue() + ", current depth:" + currentDepth);
        maxDepth = Math.max(currentDepth, maxDepth);
        traverse(root.getLeftNode());
        traverse(root.getRightNode());
        currentDepth--;
        System.out.println("before leaving the node value:" + root.getNodeValue() + ", current depth:" + currentDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeftNode(new TreeNode(9));
        TreeNode rightTree = new TreeNode(20);
        rightTree.setLeftNode(new TreeNode(15));
        rightTree.setRightNode(new TreeNode(7));
        root.setRightNode(rightTree);
        MaxDepth maxDepth = new MaxDepth();
        maxDepth.traverse(root);
        System.out.println("The max depth of the tree is:" + maxDepth.maxDepth);
    }
}
