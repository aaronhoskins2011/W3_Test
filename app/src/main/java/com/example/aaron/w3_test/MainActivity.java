package com.example.aaron.w3_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Integer> sortedArray;
    List<Integer> intPassed  = new ArrayList<>();
    String orgString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initArray();
        taskOne(intPassed);
        String patternToRemv = "og";
        orgString = "frog";
        Log.d("TAG", "onCreate: " + removePattern(patternToRemv));
    }

    /**************************************************************************************
    **  Task 1:                                                                          **
    **      Sort the array with multiple same values in the array in an ascending order. **
    **              Input: {2,8,9,3,4,3,2,6,6,2,4,9,8}                                   **
    **              Output: {2,2,2,3,3,4,4,6,6,8,8,9,9}                                  **
    **************************************************************************************/

    public void taskOne(List<Integer> intArray){
        Log.d("TAG", "taskOne: " + intArray.toString());
        Collections.sort (intArray);
        sortedArray = intArray;
        Log.d("TAG", "taskOne: " + sortedArray.toString());
    }
    public void initArray(){

        intPassed.add(2);
        intPassed.add(8);
        intPassed.add(9);
        intPassed.add(3);
        intPassed.add(4);
        intPassed.add(3);
        intPassed.add(2);
        intPassed.add(6);
        intPassed.add(6);
        intPassed.add(2);
        intPassed.add(4);
        intPassed.add(9);
        intPassed.add(8);

    }

    /**************************************************************************************
     **  Task 2:                                                                          **
     **      Say you have a string of characters. Write an algorithm to collect           **
     ** and return a list of all substrings such that order is maintained but characters  **
     ** may be skipped. So “frog” can produce fog, fg, rg, etc.                           **
     *************************************************************************************/
    public String removePattern(String patternToRemove){
        int patternToRemoveSize = patternToRemove.length();
        int orgStringSize = orgString.length();
        String returnString = "";
        for(int orgStrgPosition = 0; orgStrgPosition < orgStringSize; orgStrgPosition++){
            String currentChar = String.valueOf(orgString.charAt(orgStrgPosition));
            if(currentChar.equals(String.valueOf(patternToRemove.charAt(0)))){
                if(orgString.regionMatches(orgStrgPosition,patternToRemove,0,patternToRemoveSize))
                {
                    orgStrgPosition = orgStrgPosition + patternToRemoveSize-1;
                } else {
                    returnString = returnString + currentChar;
                }
            } else {
                returnString = returnString + currentChar;
            }

        }
        return returnString;
    }


}
