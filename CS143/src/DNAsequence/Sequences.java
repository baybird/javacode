import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.FileNotFoundException;

interface Sequences {
   public List<String> getDescriptions();
   public List<String> getSequences();
   public void readSequences(String fileName) throws FileNotFoundException;
   public boolean isValidSequence(int index);
   public String formatInGroups(int index, int basesPerGroup, int groupsPerLine);
   public Map<String, Integer> generateFrequencies(int index);
   public List<String> getSortedListOfSubstrings(int index);
   public String getReverseComplement(int index);
}