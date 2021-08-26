package BinaryTree;

/**
 *
 * @author robert
 */
public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T data;

    public TreeNode(T data) {
        this(data, null, null);
    }
    
    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.left = left;
        this.right= right;
        this.data = data;
    }
    
}
