package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class ContaisDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length) {
            for (int j = 0; j < nums.length; j++) {
                while (i != j) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                    break;
                }
            }
            i++;
        }
        return false;
    }
    public static boolean test(int[] nums){
        ArrayList<Integer> x = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            if(x.contains(nums[i])){
                return true;
            }else{
                x.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums= {29994,29995,29996,29997,29998,29999};
        Arrays.sort(nums);
    }
}
