package BinaryTree;

/**
 *
 * @author robert
 */
public class IntTree extends BinaryTree<Integer> {

    public IntTree() {
        super();
    }

    public IntTree(int maxNodes) {
        if (maxNodes <= 0) {
            throw new IllegalArgumentException("maxNodes: " + maxNodes);
        }

        overallRoot = buildTree(1, maxNodes);
    }

    private TreeNode buildTree(int data, int max) {
        if (data > max) {
            return null;
        } else {
            return new TreeNode(data, buildTree(data * 2, max), buildTree(data * 2 + 1, max));
        }
    }

    /**
     * Write a method sum that returns the sum of the data values stored in the
     * tree.
     *
     * @return
     */
    public int sum() {
        return sum(overallRoot);
    }

    public int sum(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int total = (int) root.data;
        total += sum(root.left);
        total += sum(root.right);

        return total;
    }

    /**
     * Write a method doublePositives that doubles all data values greater than
     * 0 in a binary tree of integers. For example, the before and after of a
     * call to doublePositives on a sample tree are shown below:
     */
    public void doublePositives() {
        doublePositives(overallRoot);
    }

    private void doublePositives(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        if (root.data > 0) {
            root.data = root.data * 2;
        }

        doublePositives(root.left);
        doublePositives(root.right);
    }

}
