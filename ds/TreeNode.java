package ds;

public class TreeNode {
    /**
     * the value of this node
     */
    private int nodeValue;

    /**
     * the node's left node
     */
    private TreeNode leftNode;

    /**
     * the node's right node
     */
    private TreeNode rightNode;

    public TreeNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
