package Algorithms;

public class Repeated_Substring {
    public static boolean repeatedSubstringPattern(String s) {
        StringBuilder a = new StringBuilder();
        boolean x = false;
        a.append(s.charAt(0));
       int i = 1;
       while(s.charAt(i)!=s.charAt(0)){
        a.append(s.charAt(i));
        i++;
       }
       int j = i;
       if(s.length() % i == 0){
           while(j != s.length()){
               if(s.substring(j,j+i).equals(a.toString())){
                   x = true;
                   j = j + i;
               }
           }
       }
   return x;
    }

    public static void main(String[] args) {
        String s = "saksaksaksaksaksaksaksak";
        System.out.println(repeatedSubstringPattern(s));
    }
}
