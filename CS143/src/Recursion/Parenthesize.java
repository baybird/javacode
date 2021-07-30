package Recursion;

/**
 *
 * @author robert
 */
public class Parenthesize {
    public static void main(String[] args) {
        System.out.println(solution("Joe Blow", 1));
    }
    
    public static String solution(String text, int count) {
        if(count < 1){
            return text;        
        }
        
        return solution("("+text+")", count-1);
    }
}
