package BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author robert
 */
public class PlayTree {

    public static void main(String[] args) {
        BinaryTree<String> app = new BinaryTree<String>();

        try {
            Scanner sc = new Scanner(new File("./src/BinaryTree/input.txt"));
            while (sc.hasNext()) {
                app.add(sc.next());

            }

            app.printTreepath();
            System.out.print("print nodes have exact two childern: ");
            app.printParentsWithTwoChildren();
            System.out.println("");
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
