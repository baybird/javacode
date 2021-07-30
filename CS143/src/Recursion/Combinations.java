package Recursion;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author robert
 */
public class Combinations {
    static Set<String> all = new HashSet<>();
    
    public static void main(String[] args) {
        combination("GOOGLE", 3);
    }
    
    private static void combination(String input, int length){
        combination(input, "", length);
    }
    
    private static void combination(String input, String chosen, int length){
//        System.out.println("input: "+input+", chosen: "+chosen);
        if(length == 0 && !all.contains(chosen)){
            all.add(chosen);
            System.out.println(chosen);
        }
        else{
            for (int i = 0; i < input.length(); i++) {
                String ch = input.substring(i, i+1);
                
                if(!chosen.contains(ch)){
                    String rest = input.substring(0, i) + input.substring(i+1);
                    combination(rest, chosen + ch, length - 1);
                }
            }
        }
    }
}
