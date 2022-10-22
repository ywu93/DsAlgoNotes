package bs;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traverse {
    /**
     * traverse a binary tree level by level
     *
     * @param root
     * @return
     */
    public List<Integer> levelTraverse(TreeNode root) {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeftNode(new TreeNode(9));
        TreeNode rightTree = new TreeNode(20);
        rightTree.setLeftNode(new TreeNode(15));
        rightTree.setRightNode(new TreeNode(7));
        root.setRightNode(rightTree);
        Traverse traverse = new Traverse();
        List<Integer> allNodes = traverse.levelTraverse(root);
        System.out.print("all nodes:" + allNodes);
    }
}
