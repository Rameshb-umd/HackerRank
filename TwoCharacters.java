import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                List<Integer> list = map.get(c);
                list.add(i);
                map.put(c,list);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(c,list);
            }
        }
        
        int max = 0;
        List<Character> characters = new ArrayList<Character>(map.keySet());
        for(int i=0;i<(characters.size()-1);i++){
            for(int j=i+1;j<characters.size();j++){
                List<Integer> a = map.get(characters.get(i));
                List<Integer> b = map.get(characters.get(j));                
                if(isAlternate(a,b)){                   
                    //printList(a);
                    //printList(b);
                    int currMax = a.size()+b.size();
                    if(currMax>max){
                        max = currMax;
                    }
                }
            }
        }
        System.out.println(max);
    }
    
    public static void printList(List<Integer> list){
        for(int i:list){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public static boolean isAlternate(List<Integer> l1,List<Integer> l2){
        int len1 = l1.size();
        int len2 = l2.size();
        int dif = Math.abs(len2-len1);
        if(dif!=1&&dif!=0){
            return false;
        }
        
        List<Integer> a = l1;
        List<Integer> b = l2;
        
        if(len1<len2){           
            a=l2;
            b=l1;
        }
        if(len1==len2){
            if(l1.get(0)>l2.get(0)){
                a=l2;
                b=l1;
            }
        }
        int loopVal = a.size()-dif ;         
        for(int i=0;i<loopVal;i++){           
               if(i==0||i==(loopVal-1)){
                    if(a.get(i)>b.get(i)){
                     return false;
                    }
               }else{
                   if(a.get(i)>b.get(i)||b.get(i)>a.get(i+1)||a.get(i)<b.get(i-1)){
                     return false;
                    }
               }
        }
        return true;
    }
}
