package Recursion;

/**
 *
 * @author robert
 */
public class Palindrome {
    public static void main(String[] args) {
        String test = "abba";
        System.out.println(test + " is " + isPalindrome(test));
    }

    public static boolean isPalindrome(String str) {
        if (str.length() < 2) {
            return true;
        } else {
            return str.charAt(0) == str.charAt(str.length() - 1)
                    && isPalindrome(str.substring(1, str.length() - 1));
        }
    }
}
