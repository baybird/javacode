//package Sudoku;


public class SudokuSolverEngine {

    public static void main(String[] args) {
        test("very-fast-solve.sdk");
        test("fast-solve.sdk");
        //test("unsolvable.sdk");
        //test("empty.sdk");
    }

    public static void test(String file) {
        // Here I have called my class `MySudokuBoard` if you named your class
        // differently, modify the line below to use your own class name
        MySudokuBoard board = new MySudokuBoard("boards/" + file);
        System.out.println("********* BEGIN of File: " + file + " *********");
        System.out.println("Initial board");
        System.out.println(board);
        System.out.println();

        System.out.println("Solving board...");
        long start = System.currentTimeMillis();
        if (board.solve()) {
            long stop = System.currentTimeMillis();
            System.out.printf("SOLVED in %.3f seconds.\n", ((stop - start) / 1000.0));
            System.out.println();
            System.out.println(board);
        }
        System.out.println("********************* END *********************\n");
    }
}

/*
Paste the output from JGrasp here.
Altering output will earn you an automatic zero for the assignment.

 
  ----jGRASP exec: java -ea SudokuSolverEngine
  ----   at: Jul 29, 2021 8:30:45 PM
  ----jGRASP wedge: pid for process is 10897  pids for wedge are 10895 and 10896.
  ----jGRASP wedge: CLASSPATH is ":.:::/Applications/jGRASP.app/Contents/Resources/jgrasp/extensions/classes".
  ----jGRASP wedge: working directory is /Users/robert/Projects/Java/CS143/week5/Sudoku-solve/src
  ----jGRASP wedge2: actual command sent [/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/bin/java -ea SudokuSolverEngine].
 ********* BEGIN of File: very-fast-solve.sdk *********
 Initial board
 ---------------------
 . 3 4 | 6 7 8 | 9 1 2
 . 7 2 | 1 9 5 | 3 4 8
 1 9 8 | 3 4 2 | 5 6 7
 ---------------------
 . . 9 | . 6 1 | 4 2 3
 . 2 6 | 8 5 3 | 7 9 1
 . 1 3 | 9 2 4 | . 5 6
 ---------------------
 . 6 1 | 5 3 7 | 2 8 4
 . 8 . | 4 1 9 | 6 3 5
 3 4 5 | . 8 6 | 1 7 9
 ---------------------
 
 Solving board...
 SOLVED in 0.001 seconds.
 
 ---------------------
 5 3 4 | 6 7 8 | 9 1 2
 6 7 2 | 1 9 5 | 3 4 8
 1 9 8 | 3 4 2 | 5 6 7
 ---------------------
 8 5 9 | 7 6 1 | 4 2 3
 4 2 6 | 8 5 3 | 7 9 1
 7 1 3 | 9 2 4 | 8 5 6
 ---------------------
 9 6 1 | 5 3 7 | 2 8 4
 2 8 7 | 4 1 9 | 6 3 5
 3 4 5 | 2 8 6 | 1 7 9
 ---------------------
 ********************* END *********************
 
 ********* BEGIN of File: fast-solve.sdk *********
 Initial board
 ---------------------
 8 2 7 | 1 5 4 | 3 9 6
 9 6 5 | . 2 7 | 1 4 8
 3 4 1 | 6 . 9 | 7 5 2
 ---------------------
 . . . | . . . | . . .
 . . . | . . . | . . .
 6 1 8 | 9 7 . | 4 3 5
 ---------------------
 7 8 6 | 2 3 5 | . 1 4
 1 5 4 | 7 9 6 | 8 . 3
 2 3 9 | 8 4 . | . . .
 ---------------------
 
 Solving board...
 SOLVED in 0.000 seconds.
 
 ---------------------
 8 2 7 | 1 5 4 | 3 9 6
 9 6 5 | 3 2 7 | 1 4 8
 3 4 1 | 6 8 9 | 7 5 2
 ---------------------
 4 7 2 | 5 1 3 | 6 8 9
 5 9 3 | 4 6 8 | 2 7 1
 6 1 8 | 9 7 2 | 4 3 5
 ---------------------
 7 8 6 | 2 3 5 | 9 1 4
 1 5 4 | 7 9 6 | 8 2 3
 2 3 9 | 8 4 1 | 5 6 7
 ---------------------
 ********************* END *********************
 
 
  ----jGRASP wedge: exit code for process is 0.
  ----jGRASP: operation complete.
 
*/
