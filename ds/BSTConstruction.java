package ds;

/**
 * Construct a binary search tree (BST)
 */
public class BSTConstruction {
    private TreeNode addTreeNode(TreeNode root, int value) {
        if (null == root) {
            return new TreeNode(value);
        }
        if (root.getNodeValue() > value) {
            addTreeNode(root.getLeftNode(), value);
        } else {
            addTreeNode(root.getRightNode(), value);
        }
        return root;
    }
    

    public static void main(String[] args) {

    }
}
