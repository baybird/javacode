import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinaryIntTreeTest {

// buildTree(5) looks like this sideways:
//    3    
//     
// 1
//       5
//    2
//       4

  @Test
  public void testBuildTree() {
    BinaryIntTree tester = new BinaryIntTree();
    
    // add 1 elements to tree
    tester.buildTree(1);
    assertEquals("after adding nodes to tree the inorder print should be", "1", tester.getInOrder());

    // add 5 elements to tree
    tester.buildTree(5);
    assertEquals("after adding nodes to tree the inorder print should be", "4 2 5 1 3", tester.getInOrder());

    tester.printSidewaysIndented();
  }
  
  
  @Test
  public void testGetPreOrder() {
    BinaryIntTree tester = new BinaryIntTree();

    // add 5 elements to tree
    tester.buildTree(5);
    assertEquals("after adding nodes to tree the inorder print should be", "1 2 4 5 3", tester.getPreOrder());
  }

  @Test
  public void testGetInOrder() {
    BinaryIntTree tester = new BinaryIntTree();

    // add 5 elements to tree
    tester.buildTree(5);
    assertEquals("after adding nodes to tree the inorder print should be", "4 2 5 1 3", tester.getInOrder());
  }
  
  @Test
  public void testGetPostOrder() {
    BinaryIntTree tester = new BinaryIntTree();

    // add 5 elements to tree
    tester.buildTree(5);
    assertEquals("after adding nodes to tree the inorder print should be", "4 5 2 3 1", tester.getPostOrder());
  }

}