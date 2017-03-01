import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String s = (String)in.nextLine().toLowerCase();
        int[] freqMap = new int[256];
        for(int i=0;i<s.length();i++){
            int ascii = s.charAt(i);
            freqMap[ascii] = 1;
        }
        for(int i = 'a';i<'z';i++){
            if(freqMap[i]==0){
                System.out.println("not pangram");
                return;
            }
        }
        System.out.println("pangram");
    }
}