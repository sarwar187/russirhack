/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package russirhackathon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class RussirHackathon {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        SimilarityComputation sm = new SimilarityComputation();
        
        Scanner sc = new Scanner(new File("F://hackathon//user.csv"));
        
        int mat[][] = new int[StaticVariables.row][StaticVariables.column];
        int userNumber=0;
        while(sc.hasNext()){
            String str = sc.next();
            StringTokenizer st = new StringTokenizer(str,",");
            int value=0;
            while(st.hasMoreTokens()){
                mat[userNumber][value] = Integer.parseInt(st.nextToken());
                value++;
            } 
            userNumber++;
        }
        sc = new Scanner(new File("F://hackathon//user_rec.csv"));
        ArrayList<Integer> userRec = new ArrayList<>();
        while(sc.hasNext()){
            userRec.add(Integer.parseInt(sc.next()));            
        }
        
        /*for(int i =0;i<StaticVariables.row;i++){
            for(int j=0;j<StaticVariables.column;j++)
                System.out.print(mat[i][j]);
            System.out.println();
        }*/
                
        
        for (Integer userRecVar : userRec) {
            //System.out.println("var " + userRecVar);
            //System.out.println("working");
            ArrayList<User> userList = sm.computeEucledian(mat, StaticVariables.row, StaticVariables.column, userRecVar);
            int k = StaticVariables.k;
            for(int i=0;i<k;i++){
                System.out.print(userList.get(i).userId + ",");
            }
            System.out.println();
        }
       
    }
    
}
