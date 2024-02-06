package Algorithms;

public class SplittingAString {
//    String left;
//    String right;
    public static int maxScore(String s) {
        int a = 0;
        int max = 0;
        for(int i = 0; i< s.length()-1; i++) {
            int length = 0;
            while (a != s.length()) {
                if (a <= i) {
                    if (s.charAt(a) == '0') {
                        length++;
                    }
                    a++;
                } else {
                    if (s.charAt(a) == '1') {
                        length++;
                    }
                    a++;
                }
            }
            if (max < length) {
                max = length;
            }
            a = 0;

            // }else{
            //     // int length1 = 0;
            //     // for(int j = 0 ; j < s.length(); j++){
            //     // if(s.charAt(0)=='0'){
            //     //   length1++;
            //     // }if(s.charAt(1)=='1'){
            //     //     length1++;
            //     // }
            //     // }
            //  if(max < length1){
            //    max = length1;
            //}
            //}


        }
        return max;
    }

    public static void main(String[] args) {
        String a = "01001";
        System.out.println(maxScore(a));
    }
}
