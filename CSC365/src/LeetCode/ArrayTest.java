package Algorithms;

public class ArrayTest {

    public static int[][] imageSmoother(int[][] img) {
        int count = 9;
        int x = 0;
        int y = 0;
        for(int i = 0; i < img.length ; i++) {
            for(int j = 0 ; j < img[0].length; j++ ){
                   if(i - 1 < 0 || i + 1 >= img.length){
                       count -= 3;
                       if(j-1 < 0 || j + 1 >= img.length){
                           count -=2;
                       }
                   }else if(j - 1< 0 || j - 1 >= img.length){
                           count -= 3;
                       }
                   img[i][j] = (img[i-1][j-1] + img[i-1][j] + img[i-1][j+1]
                                    + img[i][j-1]+ img[i][j] + img[i][j+1]+
                                    img[i+1][j-1] + img[i+1][j] + img[i+1][j+1])/count;
            }
        }
        return img;
     }

    public static void main(String[] args) {
        int[][] a = {{1,0,1},{0,1,0},{1,0,1}};
        imageSmoother(a);
    }
}
