package DNAfrequence;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robert
 */
public class PlayDNA {

    public static void main(String[] args) {
        testGetSortedListOfSubstrings();
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
