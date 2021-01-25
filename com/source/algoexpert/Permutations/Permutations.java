package com.source.algoexpert.Permutations;
import java.util.*;

public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(array.size() == 0){
            return new ArrayList<List<Integer>>();
        }

        for(int i=0;i<array.size();i++){
            result = generatePermsForI(array,i);
            //result.addAll(output);
        }

        return result;
    }

    private static ArrayList<List<Integer>> generatePermsForI(List<Integer> array, Integer i){
        if(array.size() == 2){
            ArrayList<List<Integer>> granularOutput = new ArrayList<List<Integer>>();
            ArrayList<Integer> granule1 = new ArrayList<Integer>();
            granule1.add(array.get(0));
            granule1.add(array.get(1));
            granularOutput.add(granule1);
            ArrayList<Integer> granule2 = new ArrayList<Integer>();
            granule2.add(array.get(1));
            granule2.add(array.get(0));
            granularOutput.add(granule2);

            return granularOutput;
        }

        ArrayList<List<Integer>> finalOutput = new ArrayList<List<Integer>>();
        List<Integer> tempList = getTempListWithoutI(array,i);

        for(int j=0;i<tempList.size();j++){
            ArrayList<List<Integer>> output = generatePermsForI(tempList, j);


            for(int k=0;k<output.size();k++){
                List<Integer> perms = new ArrayList<>();
                perms.add(array.get(i));
                perms.addAll(output.get(k));
                finalOutput.add(perms);
            }

        }
        //Integer prefix = array.get(i);



        return finalOutput;
    }

    private static List<Integer> getTempListWithoutI(List<Integer> array, Integer i){
        List<Integer> response = new ArrayList<>();
        for(int j=0;j<array.size();j++){
            if(j == i)
                continue;
            response.add(array.get(j));
        }

        return response;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println("Permuations : " + Permutations.getPermutations(array));
    }

}
