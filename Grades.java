/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grades;

import java.util.Arrays;

/**
 *
 * @author DK
 */
public class Grades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float grades[] = {99,81,73,67,88,75,92,90,84};
        //determine mean & print to console
        int n = grades.length;
        float total = 0;
                
        for (float grade : grades){
            total += grade;
        }
        float mean = total/n;
        System.out.println(mean);
        //determine median & print to console
        float median;
        Arrays.sort(grades);
        
        if(n % 2 == 1){
            int index = (n-1)/2;
            median = grades[index];
            System.out.println(median);
        }else{
            int index = n/2;
            median = (grades[index] + grades[index-1])/2;
            System.out.println(median);
        }
        //Determine standard deviation & print to console
        float counter = 0;
        for (float grade : grades){
            counter += Math.pow((grade - mean),2);
        }
        double stdev = Math.sqrt(counter/(n-1));
        System.out.println(stdev);
    }
    
}
