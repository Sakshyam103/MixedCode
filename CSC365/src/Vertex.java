//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Vertex implements Comparable<Vertex>, Serializable {
//    private String name;
//    private double distance = Double.MAX_VALUE;
//
//    private Vertex disjointset;
//
//    int disjointSetSize;
//
//    void initializeDisjointSet(){  //this is for the root
//        disjointset = this;
//        disjointSetSize = 1;
//    }
//
//    Vertex findDisjointSet(){
//        Vertex d = disjointset, t= d;
//        while(t != (t = t.disjointset));
//        while(d != t){
//            Vertex p = d.disjointset; d.disjointset = t; d=p;
//        }
//        return t;
//    }
//
//    void unionDisjointSets(Vertex x, Vertex y){
//        Vertex a = x.findDisjointSet(), b = y.findDisjointSet();
//        if(a != b){
//            if(a.disjointSetSize < b.disjointSetSize){
//                a.disjointset = b;
//                b.disjointSetSize += a.disjointSetSize;
//            }else{
//                b.disjointset = a;
//                a.disjointSetSize += b.disjointSetSize;
//
//            }
//        }
//    }
//
//    private List<Edge> edgeList = new ArrayList<Edge>();
//  //  private Vertex source;
//   // private boolean alreadyVisited;
//
//    private int x;
//    private int y;
//
//    public Vertex (String name, int x , int y){
//        this.name = name;
//        this.x = x;
//        this.y = y;
//    }  //constructor with the name
//
//
//    public int getX(){
//        return x;
//    }
//
//    public int getY(){
//        return y;
//    }
//
//    public String getName(){
//        return this.name;
//    }   // get the name
//
//    public void setDistance(double distance){
//        this.distance = distance;
//    }   // set the distance
//
//    public double getDistance(){
//        return this.distance;
//    }   //get the distance
//
//    public void addEdge(Edge edge){
//        this.edgeList.add(edge);
//    }   // add the edge
//
//    public List<Edge> getEdgeList(){
//        return this.edgeList;
//    }  // get the edge list
//
//    public void setSource(Vertex source){
//        this.source = source;
//    }    //set the source
//
//    public Vertex getSource(){
//        return this.source;
//    }    //get the source
//
//    public  void setAlreadyVisited(boolean alreadyVisited){
//        this.alreadyVisited = alreadyVisited;     // set the boole
//    }
//
//    public boolean getAlreadyVisited(){
//        return  this.alreadyVisited;
//    }   //
//    @Override
//    public int compareTo(Vertex o) {
//        return Double.compare(this.distance, o.distance);
//    }
//
//    public String toString(){
//        return this.name;
//    }
//}
