//import java.util.*;
//
//public class DijkstraShortestPath {
//    public DijkstraShortestPath(){
//    }
//
//    public void calculate(Vertex source){   //calculate the Dijkstra Shortest Path
//        PriorityQueue<Vertex> queue = new PriorityQueue<>();  //using a queue
//        source.setDistance(0);    //setting the distance to 0
//        source.setAlreadyVisited(true);    // setting the already visited to true
//        queue.add(source);        // add the source to the queue
//        while (!queue.isEmpty()){      // if queue is not empty
//            Vertex topVertex = queue.poll();    // get the first element
//            List<Edge> vertexEdgeList = topVertex.getEdgeList();  //get all the edges
//            for(Edge e: vertexEdgeList){    // select from the edges
//                Vertex edgeVertex = e.getDestination();   //get the destination vertex
//                if(e.getDestination() != null && !edgeVertex.getAlreadyVisited()){   // if the destination is not null and the destination is already visited
//                    double distance = topVertex.getDistance() + e.getWeight();  // calculate the distance = destination distance + edge weight
//                    if(distance < edgeVertex.getDistance()){   // if the calculated distance is less than the destination distance
//                        queue.remove(edgeVertex);   // remove the destination vertex
//                        edgeVertex.setDistance(distance);   // set new distance
//                        edgeVertex.setSource(topVertex);   // set the source of the destination vertex
//                        queue.add(edgeVertex);   // add the destination vertex to the queue
//                    }
//                }
//            }
//            topVertex.setAlreadyVisited(true);   // set the top vertex to true
//        }
//    }
//
//    public  List<Vertex> getShortestPath(Vertex target){    //to find the shortest path
//        List<Vertex> path = new ArrayList<>();    // make an arrayList of vertex
//        for(Vertex vertex = target; vertex!=null; vertex = vertex.getSource()){   // go through each vertex unless the source is null or parent is null
//            path.add(vertex);   // add the vertex
//            System.out.println(vertex.getName());   // print the name of the vertex
//        }
//        Collections.reverse(path);   // change the direction of the path since it was opposite
//        return path;   // return the path
//    }
//}
