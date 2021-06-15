// Name: Abraham Osman 
// UFID: 1641-1582


package com.mycompany.gradingapplication;

import java.util.*;

// @author bramo
public class GradingApplication {

    // Generate scores
// Method header 
    public static double[] generateScores(int M, int N) {
// Method body 
        double[] genScoreArr = new double[M];

        Random r = new Random();
        for (int i = 0; i < genScoreArr.length; i++) {
            genScoreArr[i] = r.nextInt(N + 1);
        }
        return genScoreArr;
    }

    // Compute total 
    // Write a method calledcomputeTotal thatwill take two arraysof doubles
    //(examScores and hwScores) as parameters and returns an array that has 
    //the total scores of all the students. totalScore = (75 x  examScore/ 200) + (25 x hwScore/ 100)
    // method header 
    public static double[] computeTotal(double[] examScores, double[] hwScores) {

        // method body 
        double[] totalScoreArr = new double[examScores.length];

        for (int i = 0; i < totalScoreArr.length; i++) {

            totalScoreArr[i] = (75 * examScores[i] / 200) + (25 * hwScores[i] / 100);
        }
        return totalScoreArr;
    }
    // Compute Grade    

    //Write a method called computeGrade that will take the total score of
    //onestudent as parameter and compute and return the grade that the 
    //student earns. The grading scheme is:  A: >= 80, B: [60, 80),  C: < 60. 
    //Note that B:[60, 80) means a student gets a B if his score is >= 60, 
    //but strictly less than 80.Note that this method is calculating the grade of only onestudent.
    // Method header  
    public static char[] computeGrade(double[] totalScore) {
        // Method body 

        char[] grade = new char[totalScore.length];
        for (int i = 0; i < totalScore.length; i++) {

            if (totalScore[i] >= 80) {
                grade[i] = 'A';
            } else if (totalScore[i] >= 60) {
                grade[i] = 'B';
            } else if (totalScore[i] < 60) {
                grade[i] = 'C';
            }
        }
        return grade;
    }

    // compute max 
    //Write a method called computeMaxthat takes adoublearray as a parameter 
    // and return the maximum value that appears in the array.  
// method header
    public static double computeMax(double[] maxVal) {
        double max = 0;
        for (int i = 0; i < maxVal.length; i++) {
            if (maxVal[i] > max) {
                max = maxVal[i];
            }
        }
        return max;
    }
    // main method 

    public static void main(String[] args) {

        //a.Call the generateScoresmethod to generates random exam score in the range [0, 200] for 11 students and store it in an arrayof doubles. 
        double[] examScores = generateScores(11, 200);

        // b.Call the generateScoresmethod to generates random hwscore in the range [0, 100] for 11 students and store it in an array of doubles. 
        double[] hwScores = generateScores(11, 100);

        //c.Call the computeTotalmethod to calculate the total scores of all these studentsand store it in a double array.
        double[] totalScore = computeTotal(examScores, hwScores);

        //d.Compute the grades for all the 11students using the computeGrademethodand store it in an arrayof appropriate data type. 
        char[] finalGrade = computeGrade(totalScore);

        //e.Compute the maximumof the exam scores, the maximumof homework scores andthe maximumof total scores using the computeMaxmethod. 
        double maxExam = computeMax(examScores);
        double maxHw = computeMax(hwScores);
        double maxTotal = computeMax(totalScore);

        //f.display the students’ exam, homework, total scores and gradeson the screen in the same format as shown in the sample output below.  
        //g.Displays the maximum of the exam, hw and total scores as shown in the sample output
        display(examScores, hwScores, totalScore, finalGrade, maxExam, maxHw, maxTotal);

    }

    // display 
    public static void display(double[] examScore, double[] hwScore, double[] totalScore, char[] grade,
            double maxExam, double maxHw, double maxTotal) {
        System.out.printf("%-10s%-10s%-10s%10s\n","Exam","HW","Total","Grade");
        for (int i = 0; i < totalScore.length; i++)
        {
            System.out.printf("%-10.1f%-10.1f%-10.1f%10c\n",examScore[i],hwScore[i],totalScore[i],grade[i]);       
        }
        
        
        System.out.printf("\n%-20s%-10.1f\n","Exam Max =", maxExam); 
       
        System.out.printf("%-20s%-10.1f\n", "HW Max =", maxHw);
        System.out.printf ("%-20s%-10.1f\n", "Total Max =", maxTotal);
    }
}
