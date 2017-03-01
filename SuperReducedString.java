import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = (String)in.nextLine();
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(!stack.isEmpty()){
                char next = stack.peek();
                if(next==c){
                    stack.pop();
                }else{
                    stack.add(c);
                }
            }else{
                stack.add(c);
            }
        }
        
        if(stack.isEmpty()){
            System.out.println("Empty String");
        }else{
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i));
            }
        }
        
    }
    
}