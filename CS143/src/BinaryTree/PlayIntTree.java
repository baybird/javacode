package BinaryTree;

/**
 *
 * @author robert
 */
public class PlayIntTree {

    public static void main(String[] args) {
        IntTree app = new IntTree(6);
        app.printTreepath();
        app.printPreorder();
        app.printInorder();
        app.printPostorder();
        app.printBreadthFirst();
        app.printDepthFirst();

        System.out.println("Height: " + app.height());
        System.out.println("Leaves: " + app.countLeaves());
        System.out.println("Size: " + app.size());
        System.out.println("Sum of tree: " + app.sum());

//        app.removeLeaves();
//        app.printTreepath();
        System.out.print("print nodes at level 3: ");
        app.printLevel(3);
        System.out.println("");

        System.out.print("print nodes have exact two childern: ");
        app.printParentsWithTwoChildren();
        System.out.println("");

    }
}
