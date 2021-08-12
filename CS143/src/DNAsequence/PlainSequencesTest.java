

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.*;

public class PlainSequencesTest {

   @Test
   public void testReadSequences() {
      Sequences tester = new PlainSequences();
      String fileName = "peptide_mRNA.text";
    
      try {
         tester.readSequences(fileName);
      } catch (FileNotFoundException e) { 
      }
    
      assertEquals("after reading file the number of sequences should be 1", 1, tester.getSequences().size());
      assertEquals("after reading file the description of sequences at index 0 should be peptide_mRNA.text", "peptide_mRNA.text", tester.getDescriptions().get(0));
   }
   
   @Test(expected = FileNotFoundException.class)
   public void testFileNotFoundExceptionIsThrown() throws FileNotFoundException {
      Sequences tester = new PlainSequences();
      String fileName = "noFileHere.txt";
      tester.readSequences(fileName);
   }
  
   @Test
   public void testIsValidSequences() {
      Sequences tester = new PlainSequences();
      String fileName = "peptide_mRNA.text";
    
      try {
         tester.readSequences(fileName);
      } catch (FileNotFoundException e) { 
      }
    
      assertEquals("the first sequence read should be valid", true, tester.isValidSequence(0));
   }

   @Test
   public void formatInGroups() {
      Sequences tester = new PlainSequences();
      String fileName = "peptide_mRNA.text";
      String expected = 
      "ACAAGATGCC ATTGTCCCCC GGCCTCCTGC TGCTGCTGCT CTCCGGGGCC ACGGCCACCG \n" +
      "CTGCCCTGCC CCTGGAGGGT GGCCCCACCG GCCGAGACAG CGAGCATATG CAGGAAGCGG \n" +
      "CAGGAATAAG GAAAAGCAGC CTCCTGACTT TCCTCGCTTG GTGGTTTGAG TGGACCTCCC \n" +
      "AGGCCAGTGC CGGGCCCCTC ATAGGAGAGG AAGCTCGGGA GGTGGCCAGG CGGCAGGAAG \n" +
      "GCGCACCCCC CCAGCAATCC GCGCGCCGGG ACAGAATGCC CTGCAGGAAC TTCTTCTGGA \n" +
      "AGACCTTCTC CTCCTGCAAA TAAAACCTCA CCCATGAATG CTCACGCAAG TTTAATTACA \n" +
      "GACCTGAA";   
    
      try {
         tester.readSequences(fileName);
      } catch (FileNotFoundException e) { 
      }
    
      String actual = tester.formatInGroups(0, 10, 6);    
      assertEquals("the string for sequence 0 in goups of 10 bases with 6 groups per line", expected, actual);
   }
   
   @Test
   public void generateFrequencies() {
      Sequences tester = new PlainSequences();
      String fileNameLarge = "peptide_mRNA.text";
      String fileNameSmall = "plainExampleSmall.text";
             
      Map<String, Integer> answersMap = new HashMap();
         answersMap.put("GG",1);
         answersMap.put("GGCAG",1);
         answersMap.put("A",2);
         answersMap.put("GGC",1);
         answersMap.put("GCAG",1);
         answersMap.put("C",1);
         answersMap.put("GCA",1);
         answersMap.put("AG",1);
         answersMap.put("G",3);
         answersMap.put("CAGA",1);
         answersMap.put("GGCAGA",1);
         answersMap.put("GA",1);
         answersMap.put("AGA",1);
         answersMap.put("GC",1);
         answersMap.put("CA",1);
         answersMap.put("GGCA",1);
         answersMap.put("CAG",1);
         answersMap.put("GCAGA",1);
         
       try {
         tester.readSequences(fileNameSmall);
      } catch (FileNotFoundException e) { 
      }
    
      Map frequencies = tester.generateFrequencies(0);    
      assertEquals("the number of distinct substrings in sequence 0 was not correct.", 18, frequencies.size());
      
      // this original test was not written correctly because it used the map's toString output but the ordering of the entries in a map is not guaranteed so the toString might show different orderings
      // assertEquals("the frequencies were not as expected.", "{GG=1, GGCAG=1, A=2, GGC=1, GCAG=1, C=1, GCA=1, AG=1, G=3, CAGA=1, GGCAGA=1, CAG=1, GCAGA=1, GA=1, AGA=1, GC=1, CA=1, GGCA=1}", frequencies.toString());
     
      // this test is better in that it compares the two maps using the Map equals method which does the expected thing of making sure all the keys and all the values are the same for both maps
      assertEquals("the frequencies were not as expected.", answersMap, frequencies);
      
      
      tester = new PlainSequences();
      try {
         tester.readSequences(fileNameLarge);
      } catch (FileNotFoundException e) { 
      }
    
      frequencies = tester.generateFrequencies(0);    
      assertEquals("the number of distinct substrings in sequence 0 was not correct.", 66491, frequencies.size());
   }

   @Test
   public void testGetSortedListOfSubstrings() {
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
      assertEquals("the sorted substrings is not right", answer,sortedSubStrings);
   }
   
   @Test
   public void testGetReverseComplement() {
      Sequences tester = new PlainSequences();

      String fileName = "plainExampleSmall.text";
      try {
         tester.readSequences(fileName);
      } catch (FileNotFoundException e) { 
      }
      String answer = "TCTGCC"; //original is GGCAGA  //T->A, A->T, C->G, G->C and reverse to get TCTGCC
      String reverseComplement = tester.getReverseComplement(0);
      assertEquals("the reverse complement is not right", answer,reverseComplement);

      tester = new PlainSequences();
      fileName = "peptide_mRNA.text";
      try {
         tester.readSequences(fileName);
      } catch (FileNotFoundException e) { 
      }
      answer = "TTCAGGTCTGTAATTAAACTTGCGTGAGCATTCATGGGTGAGGTTTTATTTGCAGGAGGAGAAGGTCTTCCAGAAGAAGTTCCTGCAGGGCATTCTGTCCCGGCGCGCGGATTGCTGGGGGGGTGCGCCTTCCTGCCGCCTGGCCACCTCCCGAGCTTCCTCTCCTATGAGGGGCCCGGCACTGGCCTGGGAGGTCCACTCAAACCACCAAGCGAGGAAAGTCAGGAGGCTGCTTTTCCTTATTCCTGCCGCTTCCTGCATATGCTCGCTGTCTCGGCCGGTGGGGCCACCCTCCAGGGGCAGGGCAGCGGTGGCCGTGGCCCCGGAGAGCAGCAGCAGCAGGAGGCCGGGGGACAATGGCATCTTGT";
      reverseComplement = tester.getReverseComplement(0);
      assertEquals("the reverse complement is not right", answer,reverseComplement);

   }
   

}