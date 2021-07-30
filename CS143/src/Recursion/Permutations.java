package Recursion;

/**
 *
 * @author robert
 */
public class Permutations {
    static int n=0;
    public static void main(String[] args) {
        permute("012345");
    }
    
    public static void permute(String input) {
        permute(input, "");
        System.out.println("******* "+ n + " *******");
    }
    
    public static void permute(String input, String chosen) {
        if(input.length() == 0){
            n+=1;
            System.out.println(chosen);
        }
        else{
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i); // choose
                String newInput = input.substring(0, i) + input.substring(i+1); // remove
                String newChosen= chosen + ch;
                permute(newInput, newChosen);
            }
        }
    }
    
    public static void permute2(String input, String chosen) {
        if (input.length() == 0) {
            System.out.println(chosen);
        }
        else{
            for (int i = 0; i < input.length(); i++) {
                String ch = input.substring(i, i + 1);   
                String rest = input.substring(0, i) + input.substring(i+1);
                String newChosen = chosen + ch;
                permute2(rest, newChosen);
            }        
        }
    }
}
