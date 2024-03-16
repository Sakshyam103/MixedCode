package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<Integer> d = new ArrayList<>();
        int count = 0;
        List<List<String>> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        while(count < strs.length) {
            while (!d.contains(count)) {
                String x = strs[count];
                b.add(x);
                String sortedStr = sortedString(x);
                for (int i = count + 1; i < strs.length; i++) {
                    if (sortedStr.equals(sortedString(strs[i]))) {
                        b.add(strs[i]);
                        d.add(i);
                    }
                }
                a.add(b);
                count++;
                if (count == strs.length  || strs.length == 1) {
                    break;
                }
                b = new ArrayList<>();


            }
            count++;
            if (count == strs.length || strs.length == 1) {
                break;
            }
        }

        return a;
    }

    public static String sortedString(String a){
        char[] ch = a.toCharArray();
        Arrays.sort(ch);
        a = new String(ch);
        return a;
    }

    public static void main(String[] args) {
        String[] x = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(x));
    }
}
