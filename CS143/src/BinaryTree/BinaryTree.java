package BinaryTree;

import java.util.*;

/**
 *
 * @author robert
 */
public class BinaryTree<T extends Comparable<T>> {

    protected TreeNode<T> overallRoot;

    public BinaryTree() {
        overallRoot = null;
    }

    public void add(T input) {
        overallRoot = add(overallRoot, input);
    }

    protected TreeNode<T> add(TreeNode<T> root, T input) {

        if (root == null) {
            root = new TreeNode<>(input);
        } else {
            int compareResult = root.data.compareTo(input);

            if (compareResult > 0) { // src. >= tar.
                root.left = add(root.left, input); // recursion
            } else if (compareResult < 0) {// src. < tar. 
                root.right = add(root.right, input); // recursion
            }
            // skip duplicates
        }

        return root;
    }

    public void printTreepath() {
        System.out.println("********* tree path *********");
        if (overallRoot == null) {
            System.out.println("null");
        } else {
            printTreepath(overallRoot, 0);
        }
    }

    public void printTreepath(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        printTreepath(root.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(root.data);
        printTreepath(root.left, level + 1);
    }

    public void printPreorder() {
        System.out.print("Pre-order: ");
        printPreorder(overallRoot);
        System.out.println("");

    }

    protected void printPreorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + ",");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public void printInorder() {
        System.out.print("In-order: ");
        printInorder(overallRoot);
        System.out.println("");

    }

    protected void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + ",");
            printInorder(root.right);
        }
    }

    public void printPostorder() {
        System.out.print("Post-order: ");
        printPostorder(overallRoot);
        System.out.println("");

    }

    protected void printPostorder(TreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + ",");

        }
    }

    /**
     * Counting Levels
     *
     * @return
     */
    public int height() {
        return height(overallRoot);
    }

    /**
     * post: Counting Levels
     *
     * @param root
     * @return
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * post: count of leaves
     */
    public int countLeaves() {
        return countLeaves(overallRoot);
    }

    /**
     * Counting Leaves
     *
     * @param root
     * @return
     */
    public int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }

    public void printBreadthFirst() {
        System.out.print("Breadth First: ");
        if (overallRoot == null) {
            System.out.println("empty tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(overallRoot);
        while (!queue.isEmpty()) {
            TreeNode current = queue.peek();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            System.out.print(queue.remove().data + ",");
        }
        System.out.println("");
    }

    /**
     * post: print pre-order without recursion
     */
    public void printDepthFirst() {
        System.out.print("Depth First: ");
        if (overallRoot == null) {
            System.out.println("empty tree");
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(overallRoot);
        while (st.isEmpty() == false) {
            TreeNode node = st.pop();
            System.out.print(node.data + ",");
            if (node.right != null) {
                st.push(node.right);
            }
            if (node.left != null) {
                st.push(node.left);
            }
        }
        System.out.print("\n");
    }

    /**
     * post: return the total number of nodes.
     *
     * @return
     */
    public int size() {
        return size(overallRoot);
    }

    /**
     * count the total number of nodes with recursion
     *
     * @param root
     * @return
     */
    protected int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        count += size(root.left);
        count += size(root.right);
        return count;
    }

    /**
     * count the total number of nodes without recursion.
     *
     * @param root
     * @return
     */
    protected int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        Stack<TreeNode> st = new Stack<>();
        st.push(overallRoot);
        while (!st.isEmpty()) {
            TreeNode current = st.pop();
            if (current.left != null) {
                count++;
                st.push(current.left);
            }

            if (current.right != null) {
                count++;
                st.push(current.right);
            }
        }
        return count;
    }

    /**
     * Write a method removeLeaves that removes the leaves from a tree. A leaf
     * node that has empty left and right subtrees. If a variable tree refers to
     * the first tree below, the call of tree.removeLeaves(); should remove the
     * four leaves from the tree (the nodes with data values 1, 4, 6, and 0)
     * leaving the next tree shown below.
     */
    public void removeLeaves() {
        overallRoot = removeLeaves(overallRoot);
    }

    public TreeNode<T> removeLeaves(TreeNode<T> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);

        return root;
    }

    /**
     * Write a method printLevel that accepts an integer parameter n and that
     * prints the values at level n from the left to right, one per line. We
     * will use the convention that the overallRoot is at level 1, that its
     * children are at level 2, and so on.
     *
     * If there are no values at the level, your method should produce no
     * output. Your method should throw an IllegalArgumentException if passed a
     * value for a level n that is less than 1.
     */
    public void printLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException();
        }

        printLevel(overallRoot, level);
    }

    public void printLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        }

        printLevel(root.left, level - 1);
        printLevel(root.right, level - 1);

    }

    public void printParentsWithTwoChildren() {
        printParentsWithTwoChildren(overallRoot);
    }

    private void printParentsWithTwoChildren(TreeNode<T> root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                System.out.print(root.data + " ");
            }

            printParentsWithTwoChildren(root.left);
            printParentsWithTwoChildren(root.right);

        }
    }
}
