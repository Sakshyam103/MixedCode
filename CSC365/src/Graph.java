//import java.util.ArrayList;
//import java.util.List;
//
//public class Graph {
//    private List<Vertex> vertexList;  //arrayList of vertex
//    private List<Edge> edgeList;   // arrayList of edge
//    int disjointCount = 0;
//
//    public Graph(List<Vertex> vertexList, List<Edge> edgeList){ // constructor of Graph which takes the arraylist of vertex and edge
//        this.vertexList = vertexList;
//        this.edgeList = edgeList;
//    }
//
//    public boolean edgeSearch(Edge edge){   // check every edge
//        for(Edge e: edgeList){  //for each edges
//            if(edge.getDestination() != null && e.getSource().getName().equals(edge.getSource().getName())) return true;  //if edges destination is not null and name fo the source of e is equal to the name of the source of edge then return true;
//        }
//        return false;  // else return false
//    }
//
//
//    public List<String> disjoint(){
//        List<String> path = new ArrayList<>();  //make an arraylist of string
//        for(Edge e: edgeList){   // for each edges in edgeList
//            if(edgeSearch(e)){   //if edgeSearch (e) == true
//                if(!path.contains(e.getSource().getName())){  //if path does not contain the source name
//                    path.add(e.getDestination().getName());  // aff the name of the source to the path
//                    disjointCount++;   //increase the disjointCount by 1;
//                }
//            }
//        }
//        return path;  //return the path
//    }
//    public int getDisjointCount(){
//        return disjointCount;
//    }  //return the disjointCount
//}
