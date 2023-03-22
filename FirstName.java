import java.io.*;
import java.util.Scanner;

public class FirstName {
    public static void main(String[] args) {
        String firstNames ="";
        try{
            File file = new File(".\\first_names.txt"); //get the file with the names
            Scanner sc = new Scanner(file);
            firstNames =sc.nextLine(); //pass the value of the file to a string
        }
        catch(Exception e){
            System.out.println("Error " + e );
        }           
        
        firstNames = firstNames.replace("\"", ""); //remove quotes
        String[] names = firstNames.split("[,]",0); //convert the string in a array separating it by commas

        mergeSort(names); //I use the mergesort method for less complexity, I could use the .sort() method but I guess you wanted to see how I sorted them.
        
        long nameScore;
        long totalNameScore = 0;

        for(int i=0; i<names.length;i++)
        {
            nameScore = 1;
            for(int j=0; j<names[i].length();j++)
            {
               nameScore *= names[i].charAt(j) - 64; //we subtract 64 since so that A is equal to 1
            }

            totalNameScore += nameScore;
        }    

        System.out.println("Total Name Score:" + totalNameScore);        
    }

    private static void mergeSort(String[] inputArray) {
        int inputLength = inputArray.length;
        
        if (inputLength < 2) {
          return;
        }
        
        int midIndex = inputLength / 2;
        String[] leftHalf = new String[midIndex];
        String[] rightHalf = new String[inputLength - midIndex];
        
        for (int i = 0; i < midIndex; i++) {
          leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
          rightHalf[i - midIndex] = inputArray[i];
        }
        
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        
        merge(inputArray, leftHalf, rightHalf);
      }

      private static void merge (String[] inputArray, String[] leftHalf, String[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        
        int i = 0, j = 0, k = 0;
        
        while (i < leftSize && j < rightSize) {
          if (leftHalf[i].compareTo(rightHalf[j]) <= 0) {
            inputArray[k] = leftHalf[i];
            i++;
          }
          else {
            inputArray[k] = rightHalf[j];
            j++;
          }
          k++;
        }
        
        while (i < leftSize) {
          inputArray[k] = leftHalf[i];
          i++;
          k++;
        }
        
        while (j < rightSize) {
          inputArray[k] = rightHalf[j];
          j++;
          k++;
        }
        
      }


}
