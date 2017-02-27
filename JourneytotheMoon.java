import java.io.*;
import java.util.*;

public class Solution {
    
   public static void main(String[] args) throws Exception{
       
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);
      
       //Initialize 2D array to create Adjacency Matrix
       int[][] matrix = new int[N][N];
        for(int i = 0; i < I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            matrix[a][b] =1;
            matrix[b][a] =1;
          
        }
        //printMatrix(matrix);
        boolean[] matrix_b = new boolean[N];
        
       List<List<Integer>> countries = new ArrayList<List<Integer>>();
       for(int i=0;i<N;i++ ){
           
           if(!matrix_b[i]){
                List<Integer> country = new ArrayList<Integer>();
                Queue<Integer> q = new ArrayDeque<Integer>();
                q.add(i); 
                while(!q.isEmpty()){
                    int row = q.poll();                    
                    if(!matrix_b[row]){
                        country.add(row);
                        matrix_b[row]=true;
                        for(int j=0;j<N;j++){
                            if(matrix[row][j]==1){
                               q.add(j); 
                            }
                        }
                    }
                }
               countries.add(country);
            }
        }
       
   
       //printList(countries);       
        long combinations = 0;
        long remainingPartners = N;
        for(List<Integer> country:countries){
            long partners = country.size();
            remainingPartners = remainingPartners - partners;
            combinations = combinations + (partners * remainingPartners);
        }
       
        System.out.println(combinations);

    }
    
    /*** Print Matrix
    **/
    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++ ){
            for(int j=0;j<matrix.length;j++ ){
                System.out.print(matrix[i][j]+" ");
                            
            }
            System.out.println("");
        }
    }
    
    /*** Print List
    **/
    public static void printList( List<List<Integer>> countries){
        for(List<Integer> country:countries){
            for(int i:country){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }


 
}