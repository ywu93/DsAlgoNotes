package bs;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BsFunctions {

    /**
     * Retrieve the elements of a binary tree level by level
     *
     * @param root
     * @return all elements in a list
     */
    public static List<Integer> levelTraverse(TreeNode root) {
        List<Integer> allNodes = new ArrayList<>();
        if (root == null) {
            return allNodes;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                allNodes.add(node.getNodeValue());
                if (node.getLeftNode() != null) {
                    queue.offer(node.getLeftNode());
                }
                if (node.getRightNode() != null) {
                    queue.offer(node.getRightNode());
                }
            }
        }
        return allNodes;
    }

    public static void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // change the position of the left node and the right node
        TreeNode tmp = root.getLeftNode();
        root.setLeftNode(root.getRightNode());
        root.setRightNode(tmp);
        invertBinaryTree(root.getLeftNode());
        invertBinaryTree(root.getRightNode());
    }

//    public TreeNode buildTreeByPreOrderAndInOrder(int[] preOrder, int[] inOrder) {
//        Map<Integer, Integer> valToIndex = new HashMap<>();
//        for (int i = 0; i < inOrder.length; i++) {
//            valToIndex.put(inOrder[i], i);
//        }
//
//    }

//    private TreeNode buildTree(Map<Integer, Integer> valueToIndex,
//                               int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int endStart) {
//    }

    public static boolean isFullBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return true;
        }
        if (root.getLeftNode() != null && root.getRightNode() != null) {
            return isFullBinaryTree(root.getLeftNode()) && isFullBinaryTree(root.getRightNode());
        }
        return false;
    }


    public static void main(String[] args) {
        // construct a binary tree
        TreeNode root = new TreeNode(3);
        root.setLeftNode(new TreeNode(9));
        TreeNode rightTree = new TreeNode(20);
        rightTree.setLeftNode(new TreeNode(15));
        rightTree.setRightNode(new TreeNode(7));
        root.setRightNode(rightTree);
        System.out.println("the original sequence of the tree:" + BsFunctions.levelTraverse(root));
        // invert the tree
        BsFunctions.invertBinaryTree(root);
        System.out.println("the inverted sequence of the tree:" + BsFunctions.levelTraverse(root));
        System.out.println("The is full tree or not:" + BsFunctions.isFullBinaryTree(root));
    }
}
