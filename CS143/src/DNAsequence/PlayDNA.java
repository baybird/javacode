package DNAsequence;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robert
 */
public class PlayDNA {

    public static void main(String[] args) {
        testReverseComplement();
    }

    public static void testReverseComplement() {
        Sequences tester = new PlainSequences();
        String fileName = "plainExampleSmall.text";
        try {
            tester.readSequences(fileName);
        } catch (FileNotFoundException e) {
        }
        String answer = "TCTGCC"; //original is GGCAGA  //T->A, A->T, C->G, G->C and reverse to get TCTGCC
        String reverseComplement = tester.getReverseComplement(0);
        //assertEquals("the reverse complement is not right", answer, reverseComplement);
        System.out.println(reverseComplement.endsWith(answer));
    }

    public static void testGetSortedListOfSubstrings() {
        Sequences tester = new PlainSequences();
        String fileName = "plainExampleSmall.text";

        try {
            tester.readSequences(fileName);
        } catch (FileNotFoundException e) {
        }

        //<[A, AG, AGA, C, CA, CAG, CAGA, G, GA, GC, GCA, GCAG, GCAGA, GG, GGC, GGCA, GGCAG, GGCAGA]>
        List answer = new ArrayList();
        answer.add("A");
        answer.add("AG");
        answer.add("AGA");
        answer.add("C");
        answer.add("CA");
        answer.add("CAG");
        answer.add("CAGA");
        answer.add("G");
        answer.add("GA");
        answer.add("GC");
        answer.add("GCA");
        answer.add("GCAG");
        answer.add("GCAGA");
        answer.add("GG");
        answer.add("GGC");
        answer.add("GGCA");
        answer.add("GGCAG");
        answer.add("GGCAGA");

        List sortedSubStrings = tester.getSortedListOfSubstrings(0);

        System.out.println(sortedSubStrings);
        System.out.println(answer);
    }
}
