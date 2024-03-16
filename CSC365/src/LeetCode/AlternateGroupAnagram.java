package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlternateGroupAnagram {
//        public static List<List<String>> groupAnagrams(String[] strs) {
//            List<List<String>> result = new ArrayList<List<String>>();
//
//            Map<String, List<String>> groups = new HashMap<String, List<String>>();
//            for (int i = 0; i < strs.length; i++){
//                String str = strs[i];
//                String key = buildAnagramsKey(str);
//
//                if (!groups.containsKey(key)){
//                    groups.put(key, new ArrayList<String>());
//                }
//                groups.get(key).add(str);
//            }
//
//            for (Map.Entry<String, List<String>> pair : groups.entrySet()){
//                result.add(pair.getValue());
//            }
//
//            return result;
//        }
//
//        public static String buildAnagramsKey(String str){
//            int[] map = new int[26];
//
//            for (Character c : str.toCharArray()){
//                map[c - 'a'] += 1;
//            }
//            StringBuilder build = new StringBuilder();
//            for (int i = 0; i < 26; i++){
//                build.append(map[i]);
//                build.append((char) (i + 'a'));
//            }
//            return build.toString();
//        }
//
//    public static void main(String[] args) {
//        String[] ab = new String[]{"ab","ba","bad","good","ogod",};
//        groupAnagrams(ab);
//    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String one: strs){
            String key = getKey(one);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(one);
        }
        for(Map.Entry<String,List<String>> a: map.entrySet()){
            groups.add(a.getValue());
        }
        return groups;


        //     ArrayList<Integer> d = new ArrayList<>();
        //     int count = 0;
        //     List<List<String>> a = new ArrayList<>();
        //     List<String> b = new ArrayList<>();
        //     if(strs.length<= Math.pow(10,4)){
        //     while (count < strs.length) {
        //         while (!d.contains(count)) {
        //             String x = strs[count];
        //             b.add(x);
        //             String sortedStr = sortedString(x);
        //             for (int i = count + 1; i < strs.length; i++) {
        //                 if (sortedStr.equals(sortedString(strs[i]))) {
        //                     b.add(strs[i]);
        //                     d.add(i);
        //                 }
        //             }
        //             a.add(b);
        //             count++;
        //             if (count == strs.length || strs.length == 1) {
        //                 break;
        //             }
        //             b = new ArrayList<>();
        //         }
        //         count++;
        //         if (count == strs.length || strs.length == 1) {
        //             break;
        //         }
        //     }
        //     }

        //     return a;
        // }

        // public String sortedString(String a) {
        //     char[] ch = a.toCharArray();
        //     Arrays.sort(ch);
        //     a = new String(ch);
        //     return a;

    }
    public static String getKey(String a){
        int[] b = new int[26];
        for(Character x: a.toCharArray()){
            b[x-'a'] += 1;
        }
        StringBuilder build = new StringBuilder();
        for(int i =0; i<26; i++){
            build.append(b[i]);
            build.append(i+'a');
        }
        return build.toString();


    }

    public static void main(String[] args) {
        String[] a = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(groupAnagrams(a));
    }
}

