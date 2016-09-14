/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package russirhackathon;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASUS
 */

class User implements Comparable{
    int userId;
    double similarity;
    
    User(int userId, double similarity){
        this.userId = userId;
        this.similarity = similarity;
    }
    
    User(){
        userId = 0;
        similarity = 0;
    }
    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        if (this.similarity < user.similarity)
            return -1;
        else if (this.similarity > user.similarity)
            return 1;
        else
            return 0;
    }
}
public class SimilarityComputation {
    ArrayList<User> userList;
    SimilarityComputation(){
        userList = new ArrayList<>();
    }
    ArrayList<User> computeEucledian(int mat[][], int row, int column, Integer userId){
        userList.clear();
        //System.out.println("userId" + userId);
        for(int i=0; i<row; i++){
            if(i==userId)
                continue;
            //System.out.println("i   " + i);
            double sum = 0;
            for(int j=0;j<column;j++){
                sum+=Math.pow(mat[userId][j]-mat[i][j],2);
            }
            userList.add(new User(i,Math.sqrt(sum)));
            //System.out.println("working");
        }
        
        //for(int i=0;i<userList.size();i++)
        //    System.out.println(userList.get(i).userId);
        Collections.sort(userList);
        return userList;
    }
}
