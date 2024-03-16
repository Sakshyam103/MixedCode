package Algorithms;

import java.util.*;
import java.io.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();   //made an hashmap with key integer and value its frequency
        int[] result = new int[k];  // to store the result
        int count = 0;  // to count frequency which is always 0
        for (int i = 0; i < nums.length; i++) {   //loop through each values in nums
            if (!map.containsKey(nums[i])) {  //if new then make a new hash with key nums[i] and value 0
                map.put(nums[i], count);
            }
            map.put(nums[i], map.get(nums[i]) + 1);  // increase the value if already exists
        }
        List<Integer> x[] = new ArrayList[nums.length + 1];  //make an arraylist of array that means array to count the numbers of nums.length and ArrayList to add the value if contains more than 1 value
        for (Map.Entry<Integer, Integer> a : map.entrySet()) {  //loop through each values in hashmap
            int m = a.getValue();  // get the value
            if (x[m] == null) {   // initially the array is null so if null in x[m]
                x[m] = new ArrayList<>();   //initialize new arraylist
            }
            x[m].add(a.getKey());  // add the key in that index of frequency of key
        }       // after adding all the values some will be null
        int r = 0;   // to count each index inside arraylist
        int counter = 0;  // to count the index of result array
        for (int p = nums.length; p > 0; p--) {  // loop through the x which contains values
            while (x[p]!=null && r < x[p].size() && counter < result.length) {   // if the x[p] is not null, r counter is less than the arraylist size and result is not full(i.e counter< result.length)
                result[counter] = x[p].get(r);  //add value in result
                counter++;   //increase counter
                r++;   //increase r (r++)
            }
            r = 0;   //finally make the r = 0 to start in new array
        }
        return result;   // return the result
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,2,2,3};
        int[] x = topKFrequent(a, 2);
        for (int b : x) {
            System.out.println(b);

        }
    }
}


