/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package russirhackathon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */

class Tag implements Comparable{
    String tag;
    int frequency;
    
    Tag(String tag, int frequency){
        this.tag = tag;
        this.frequency = frequency;
    }
    
    Tag(){
        tag = "";
        frequency = 0;
    }
    @Override
    public int compareTo(Object o) {
        Tag tag = (Tag) o;
        if (this.frequency < tag.frequency)
            return -1;
        else if (this.frequency > tag.frequency)
            return 1;
        else
            return 0;
    }
}

public class UserLikes {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner sc = new Scanner(new File("F://hackathon//tags.csv"));
        HashMap<String,Integer> hashMap = new HashMap<>();
        ArrayList<Tag> tags = new ArrayList<Tag>();
        while(sc.hasNextLine()){
            String tag = sc.nextLine();
            //System.out.println(tag);
            
            StringTokenizer st = new StringTokenizer(tag,",");
            String tagg = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            //if(val>40)
            tags.add(new Tag(tagg,val));
        }
        Collections.sort(tags);
        //Collections.reverse(tags);
        sc = new Scanner(new File("F://hackathon//user_likes2.csv"));
        
        while(sc.hasNextLine()){
        
            String data = sc.nextLine();
            StringTokenizer st = new StringTokenizer(data,",");
            int userId = Integer.parseInt(st.nextToken());
            if(userId == 1234567 || userId == 1234568 || userId == 1234569){
                HashMap<String,Integer> interestMap = new HashMap<String,Integer>();
                while(st.hasMoreTokens()){
                    interestMap.put(st.nextToken(), 1);
                }
                int count=0;
                System.out.print(userId);
                for(Tag tagVal:tags){
                    if(interestMap.containsKey(tagVal.tag)){
                        System.out.print(","+tagVal.tag);
                        count++;
                    }
                    if(count==186)
                        break;
                }
                System.out.println();
            }
            
        }
        
        /*for(int i =0;i<StaticVariables.row;i++){
            for(int j=0;j<StaticVariables.column;j++)
                System.out.print(mat[i][j]);
            System.out.println();
        }*/
                
        
     
    }
}
