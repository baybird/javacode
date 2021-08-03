package DNAsequence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * <pre>
 * File         PlainSequences.java
 * Project      DNA Sequence
 * Description  This class implements the getReverseComplement() method with Java 
 *              Collections' Stack and Queues that to sort the list of all 
 *              substrings of a DNA sequence based on last week's PlainSequences 
 *              class.
 * course       CS143
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, JGRASP
 * Date         8/3/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version     1.0.0
 * </pre>
 */
public class PlainSequences implements Sequences {

    private List<String> descriptions;
    private List<String> sequences;
    
    /**
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * <pre>
    * Method           Default constructor
    * Description      Creates new instance without parameters
    * @author          <i>Robert Tang</i>
    * Date             7/21/2021
    * </pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    */
    public PlainSequences() {
        descriptions = new ArrayList<String>();
        sequences = new ArrayList<String>();
    }
    
    /**
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * <pre>
    * Method           getSortedListOfSubstrings()
    * Description      Sort the list of all substrings of a DNA sequence.
    * @param           index-int
    * @author          <i>Robert Tang</i>
    * Date             7/21/2021
    * </pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    */    
    @Override
    public List<String> getSortedListOfSubstrings(int index){
        Set<String> items = generateFrequencies(0).keySet();
        List<String> list1 = new ArrayList<>();        
        for (String item : items) {
            list1.add(item);
        }        
        Collections.sort(list1);        
        return list1;        
    }
    
    /**
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * <pre>
    * Method           generateFrequencies()
    * Description      This method generates the frequencies of all substrings 
    *                  of a DNA sequence.
    * @param           index-int
    * @author          <i>Robert Tang</i>
    * Date             7/21/2021
    * </pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    */
    @Override
    public Map<String, Integer> generateFrequencies(int index) {
        Map<String, Integer> freqMap = new HashMap<String, Integer>();        
        String orgStr = getSequences().get(index).toString();        
        for (int i = 0; i < orgStr.length(); i++) {
            for (int j = i+1; j <= orgStr.length(); j++) {
                String word = orgStr.substring(i,j);
                
                if(freqMap.containsKey(word)){
                    freqMap.put(word, freqMap.get(word) + 1);
                }
                else{
                    freqMap.put(word, 1);
                }
            }
        } 

        return freqMap;
    }
    
    /**
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * <pre>
    * Method           getDescriptions()
    * Description      This method returns the descriptions of the DNA input files
    * @author          <i>Robert Tang</i>
    * Date             7/21/2021
    * </pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    */
    @Override
    public List<String> getDescriptions() {
        return descriptions;
    }
    
    /**
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * <pre>
    * Method           getSequences()
    * Description      This method returns the sequence data.
    * @author          <i>Robert Tang</i>
    * Date             7/21/2021
    * </pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    */
    @Override
    public List<String> getSequences() {
        return sequences;
    }
    
    /**
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * <pre>
    * Method           readSequences()
    * Description      This method reads the DNA data from a specified input file
    * @param           fileName-String
    * @author          <i>Robert Tang</i>
    * Date             7/21/2021
    * </pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    */
    @Override
    public void readSequences(String fileName) throws FileNotFoundException {
        try {
            Scanner input = new Scanner(new File("DNAsequence/" + fileName));
            StringBuilder sb = new StringBuilder();

            while (input.hasNextLine()) {
                sb.append(input.next());
            }
            descriptions.add(fileName);
            sequences.add(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new FileNotFoundException();
        }
    }

    /**
     * To represent ambiguity in DNA sequences the following letters can be used
     * (following the rules of the International Union of Pure and Applied
     * Chemistry (IUPAC)): 
     *  A = adenine           
        C = cytosine            
        G = guanine             
        T = thymine           
        U = uracil
        R = G A (purine)        
        Y = T C (pyrimidine)    
        K = G T (keto)    
        M = A C (amino)
        S = G C 
        W = A T 
        B = G T C
        D = G A T
        H = A C T
        V = G C A
        N = A G C T (any)   
     *
     * @param index - int
     * @return true/false - Boolean
     */
    @Override
    public boolean isValidSequence(int index) {
        String sequencyString = sequences.get(index);
        for (int i = 0; i < sequencyString.length(); i++) {
            char dnaBase = sequencyString.charAt(i);
            if (!(dnaBase == ' '
                    || dnaBase == 'A'
                    || dnaBase == 'C'
                    || dnaBase == 'G'
                    || dnaBase == 'T'
                    || dnaBase == 'U'
                    || dnaBase == 'R'
                    || dnaBase == 'Y'
                    || dnaBase == 'K'
                    || dnaBase == 'M'
                    || dnaBase == 'S'
                    || dnaBase == 'W'
                    || dnaBase == 'B'
                    || dnaBase == 'D'
                    || dnaBase == 'H'
                    || dnaBase == 'V'
                    || dnaBase == 'N')) {
                return false;
            }
        }
        return true;
    }
    
    /**
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * <pre>
    * Method           formatInGroups()
    * Description      This method formats the DNA sequence into group as user 
    *                  specified format.
    * @param index-int
    * @param basesPerGroup-int
    * @param groupsPerLine-int
    * @return 
    * @author          <i>Robert Tang</i>
    * Date             7/21/2021
    * </pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    */
    @Override
    public String formatInGroups(int index, int basesPerGroup, int groupsPerLine) {
        String sequencyString = sequences.get(index);
        StringBuilder dnaGroups = new StringBuilder();
        final int SIZE = sequencyString.length();
        int groupCount = 0;
        for (int i = 0; i < SIZE; i++) {
            dnaGroups.append(sequencyString.charAt(i));

            if ((i + 1) % (basesPerGroup) == 0) {
                dnaGroups.append(" ");
                groupCount += 1;
            }

            if (groupCount == groupsPerLine) {
                dnaGroups.append("\n");
                groupCount = 0;
            }
        }
        return dnaGroups.toString();
    }
    
    /**
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    * <pre>
    * Method           getReverseComplement()
    * Description      This method generates the reverse complement sequence.
    *                  1) reverse the sequence of letters (i.e. "agtc" becomes "ctga").
    *                  2) make the following substitutions to all the letters in the reversed string:
    *                       t -> a, a-> t, g -> c, c-> g
    *                  3) Then finally return the string that results from doing steps 1 and 2.
    * @param           index-int
    * @return          sb-string
    * @author          <i>Robert Tang</i>
    * Date             8/3/2021
    * </pre>
    * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    */
    @Override
    public String getReverseComplement(int index) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] items = getSequences().get(index).split("");
        
        // Push the DNA code to a stack, and convert them to complement code.
        for (int i = 0; i < items.length; i++) {
            if(items[i].equalsIgnoreCase("T")){
                st.push("A");
            }
            else if(items[i].equalsIgnoreCase("A")){
                st.push("T");
            }
            else if(items[i].equalsIgnoreCase("G")){
                st.push("C");
            }
            else if(items[i].equalsIgnoreCase("C")){
                st.push("G");
            }
            else{
                st.push(items[i]);
            }
        }
        
        // Appends code from stack to a string builder
        while (!st.isEmpty()) {            
            sb.append(st.pop());
        }
        
        // return the string builder as a string
        return sb.toString();
    }
   
}
