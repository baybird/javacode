package EightQueensPuzzle;

/**
 *
 * @author robert
 */
public class QueensGame {
    public static void main(String[] args) {
        final int SIZE = 8;
        QueensBoard qb = new QueensBoard(SIZE);
//        QueensGUI qb = new QueensGUI(SIZE);
        qb.solve();
        System.out.println(qb);
    }
}
