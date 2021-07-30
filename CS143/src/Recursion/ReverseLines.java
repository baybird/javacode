/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author robert
 */
public class ReverseLines {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("./src/Recursion/file.txt"));
            solution(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void solution(Scanner input) {
        if(input.hasNextLine()){
            String next = input.nextLine();
            solution(input);
            System.out.println(next);
        }
    }
}
