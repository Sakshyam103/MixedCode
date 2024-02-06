package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SudokuSolver {

    private static Scanner scanner = new Scanner(System.in);

    public static void setScanner(Scanner customScanner) {
        scanner = customScanner;
    }
    public static void resetScanner() {
        scanner = new Scanner(System.in);
    }

    //Task 1:Function to taken input from user to create sudoku board
    public void readUserInput(int[][] board) {
        for(int i=0;i<board.length; i++){
            for(int j=0; j< board[0].length; j++){
                board[i][j] = Integer.parseInt(scanner.next());
            }
        }
    }

    //Task 1:Function to print the sudoku board
    public  void printBoard(int[][] board) {
        for(int i = 0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }


    //Task 2:Function to check whether the sudoku board given from user is valid or not
    public boolean initialValidBoard(int[][] board) {
        //boolean x = true;
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j< board.length; j++){
                if(board[i][j]!= 0){
                   //x = initialValidPlacement(board,i,j,board[i][j]);
                   if(!initialValidPlacement(board, i, j, board[i][j])){
                       return false;
                   }
                }
            }
        }
        return true;
    }


    //Task 2:Helper Function to check intial placement of numbers on the sudoku board given from user
    public  boolean initialValidPlacement(int[][] board, int row, int col, int num) {
        // Check if placing 'num' at (row, col) is valid in the row, column, and subgrid

        // Check the row


        // Check the column


        // Check the subgrid

            for(int i = 0 ; i<9 ; i++){
                if(col != i){
                    if(board[row][i] == num)
                        return false;
                }
                if(row != i){
                    if(board[i][col] == num)
                        return false;
                }
            }



        ArrayList<Integer> rows = new ArrayList<Integer>(Arrays.asList(1,4,7));
        int a = 0 , b = 0;
        if(rows.contains(row-1)){
            a = row -1 ;
        }if(rows.contains(row)){
            a = row;
        }
        if(rows.contains(row+1)){
            a = row + 1;
        }if(rows.contains(col - 1)){
            b = col -1;
        }
        if(rows.contains(col)){
            b = col;
        }
        if(rows.contains(col + 1)){
            b = col + 1;
        }
        //make changes here
        if((a-1)!=row && (b-1)!=col && board[a-1][b-1] == num){
            return false;
        }
        if((a-1)!=row && b!= col && board[a-1][b] == num){
            return false;
        }
        if((a -1)!=row && (a + 1)!=col && board[a-1][b+1]==num){
            return false;
        }if(a!=row && (b-1)>0 && board[a][b-1]== num){
            return false;
        }if(a!= row && (b + 1)!=col && board[a][b+1]==num){
            return false;
        }
        if((a + 1)!=row && (b-1)!=col && board[a+1][b-1]== num){
            return false;
        }
        if((a+1)!=row && b!=col && board[a+1][b]==num){
            return false;
        }
        if((a+1)!=row && (b+1)!=col && board[a+1][b+1]==num){
            return false;
        }

        return true;
    }


    //Task 3:Function to solve the sudoku
    public  boolean solveSudoku(int[][] board) {
        int[] a = findEmptyCell(board);
        while(a[0] != -1 && a[1] != -1) {
            for (int i = 1; i < 10; i++) {
                //boolean x = isValidPlacement(board, a[0], a[1], i);
                if (isValidPlacement(board,a[0],a[1],i)) {
                    board[a[0]][a[1]] = i;
                    if(solveSudoku(board)==true){
                        return true;
                    }else{
                        board[a[0]][a[1]] = 0;
                    }
                }
            }
            a = findEmptyCell(board);
            return false;
        }
        return true;
    }


    //Task 3:Helper Function to check for empty spaces on the board
    private  int[] findEmptyCell(int[][] board) {
        int a[] = new int[2];
        for(int i=0; i<board.length; i++){
            for(int j=0; j< board.length; j++){
                if(board[i][j]==0){
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        a[0] = -1;
        a[1] = -1;
        return a;

        //return null; // No empty cell found
    }
    //Task 3:Helper Function to check  placement of numbers on the sudoku board for solving
    private  boolean isValidPlacement(int[][] board, int row, int col, int num) {
        for(int i = 0 ; i<9 ; i++){
            if(col != i){
                if(board[row][i] == num)
                    return false;
            }
            if(row != i){
                if(board[i][col] == num)
                    return false;
            }
        }
        ArrayList<Integer> rows = new ArrayList<Integer>(Arrays.asList(1,4,7));
        int a = 0 , b = 0;
        if(rows.contains(row-1)){
            a = row -1 ;
        }if(rows.contains(row)){
            a = row;
        }
        if(rows.contains(row+1)){
            a = row + 1;
        }if(rows.contains(col - 1)){
            b = col -1;
        }
        if(rows.contains(col)){
            b = col;
        }
        if(rows.contains(col + 1)){
            b = col + 1;
        }
        //make changes here
        if(board[a-1][b-1]!=board[row][col] && board[a-1][b-1] == num){
            return false;
        }
        if(board[a-1][b]!=board[row][col] && board[a-1][b] == num){
            return false;
        }
        if(board[a-1][b+1]!=board[row][col] && board[a-1][b+1]==num){
            return false;
        }
        if(board[a][b]!=board[row][col] && board[a][b]==num){
            return false;
        }
        if(board[a][b-1]!=board[row][col] && board[a][b-1]== num){
            return false;
        }if(board[a][b+1]!=board[row][col] && board[a][b+1]==num){
            return false;
        }
        if(board[a+1][b-1]!=board[row][col] && board[a+1][b-1]== num){
            return false;
        }
        if(board[a+1][b]!=board[row][col] && board[a+1][b]==num){
            return false;
        }
        if(board[a+1][b+1]!=board[row][col] && board[a+1][b+1]==num){
            return false;
        }

        return true;

    }

    public static void main(String[] args) {

        System.out.println("Sudoku Board");
        SudokuSolver x = new SudokuSolver();
        int[][] a = new int[][]{{5,3,0,0,7,0,0,0,0}
                               ,{6,0,0,1,9,5,0,0,0}
                               ,{0,9,8,0,0,0,0,6,0}
                               ,{8,0,0,0,6,0,0,0,3}
                               ,{4,0,0,8,0,3,0,0,1}
                               ,{7,0,0,0,2,0,0,0,6}
                               ,{0,6,0,0,0,0,2,8,0}
                               ,{0,0,0,4,1,9,0,0,5}
                               ,{0,0,0,0,8,0,0,7,9}};
//        x.readUserInput(a);
        if(x.initialValidBoard(a) == true){
            if(x.solveSudoku(a) == true){

            }
        }
        x.printBoard(a);
    }
}
