package Algorithms;

import java.util.ArrayList;

public class PathCrossing {

        public static boolean isPathCrossing(String path){
            ArrayList<Graph1> a = new ArrayList<>();
            int x1 = 0;
            int y2 = 0;
            a.add(new Graph1(x1, y2));
            if (path.length() >= 1 && path.length() <= Math.pow(10, 4)) {
                for (int i = 0; i < path.length(); i++) {
                    char c = path.charAt(i);
                    switch (c) {
                        case 'N':
                            y2 += 1;
                            break;

                        case 'S':
                            y2 -= 1;
                            break;

                        case 'E':
                            x1 += 1;
                            break;

                        case 'W':
                            x1 -= 1;
                            break;
                    }
                    for (int j = 0; j < a.size(); j++) {
                        if (a.get(j).getX() == x1 && a.get(j).getY() == y2) {
                            return true;
                        }
                    }
                    a.add(new Graph1(x1, y2));
                }
            }
            return false;
        }


        public static void main (String[]args){
            String s = "NES";
            System.out.println(isPathCrossing(s));
        }
    }

class Graph1{
    int x;
    int y;
    public Graph1(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setGraph(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
