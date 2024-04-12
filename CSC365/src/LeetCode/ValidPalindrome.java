class Solution {
    public boolean isPalindrome(String s) {
        char[] a = s.replaceAll("[^A-Za-z0-9]","").toLowerCase().toCharArray();
        int x = a.length-1;
        int y = 0;
        if(a.length<2){return true;}
        while(x!=y || x!= a.length/2){
            if(a[x]!=a[y]){
                return false;
            }else{
                x--;
                y++;
                if(x==y || x== a.length/2-1){
                    break;
                }
            }
        }
        return true;
    }
}