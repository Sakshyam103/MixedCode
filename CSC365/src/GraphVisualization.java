//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//public class GraphVisualization extends JFrame {
//
//    private Graph graph;
//    private JPanel graphPanel;  // JPanel for drawing the graph
//    private JFrame frame;
//    private JTextField firstTextField;
//    private JTextField secondTextField;
//    private JScrollPane urlScrollPane;
//    private JScrollPane pathScrollPane;
//    private JList label;
//    private List<String> disjointList;
//    private static final String PATH = "C:/Users/nepal/IdeaProjects/CSC365/src";
//    private static final String urlFiles = "C:/Users/nepal/IdeaProjects/CSC365/src/Urls.txt";
//    int urlCount = 0;
//
//    List<Vertex> vertexList = new ArrayList<Vertex>();
//    List<Edge> edgeList = new ArrayList<>();
//    List<String> urlLists = new CopyOnWriteArrayList<String>();
//    List<String> medoids = new ArrayList<String>();
//    final HashTable frequencyHash = new HashTable();
//
//    public GraphVisualization() {
//        initializeGraph();
//        initComponents();
//    }
//
//    private void initializeGraph() {
////        frame = new JFrame();
////        frame.setBounds(100,100,600,600);
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.getContentPane().setBackground(Color.GRAY);
////        JTextArea textArea = new JTextArea(5, 30);
////        JTextArea pathTextArea = new JTextArea(5,30);
////        final JTextArea shortestPathTextArea = new JTextArea(5, 30);
////        firstTextField = new JTextField();
////        firstTextField.setColumns(10);
////        secondTextField = new JTextField();
////        secondTextField.setColumns(10);
////        JButton findPathButton = new JButton("Click here");
////        findPathButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                String firstUrl = firstTextField.getText();
////                String secondUrl = secondTextField.getText();
////                DijkstraShortestPath shortestPath = new DijkstraShortestPath();
////                Vertex one = new Vertex("");
////                Vertex two = new Vertex("");
////                for (Vertex v: vertexList){
////                    if(v.getName().equals(firstUrl)){
////                        one = v;
////                        System.out.println("Found one");
////                    }
////                    if(v.getName().equals(secondUrl)){
////                        two = v;
////                        System.out.println("Found second");
////                    }
////                }
////                shortestPath.calculate(one);
////                List<Vertex> path = new ArrayList<Vertex>();
////                path = shortestPath.getShortestPath(two);
////                String pathText = "";
////                for(Vertex v: path){
////                    pathText = pathText + v.getName() + "\n";
////                }
////                for (String medoid: medoids){
////                    if (pathText.contains(medoid)){
////                        pathText = pathText + "Medoid: " + medoid + "\n";
////                    }
////                }
////                shortestPathTextArea.setText(pathText);
////            }
////        });
////        urlScrollPane = new JScrollPane(textArea);
////        pathScrollPane = new JScrollPane(pathTextArea);
////        scrollPane = new JScrollPane(shortestPathTextArea);
////        JList list = new JList();
////        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
////        groupLayout.setHorizontalGroup(
////                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
////                        .addGroup(groupLayout.createSequentialGroup()
////                                .addContainerGap()
////                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
////                                        .addGroup(groupLayout.createSequentialGroup()
////                                                .addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
////                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
////                                                .addComponent(findPathButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
////                                        .addComponent(firstTextField, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
////                                        .addComponent(secondTextField, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
////                                        .addComponent(urlScrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
////                                        .addGroup(groupLayout.createSequentialGroup()
////                                                .addComponent(pathScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
////                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
////                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
////                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
////                                .addContainerGap(207, Short.MAX_VALUE))
////        );
////        groupLayout.setVerticalGroup(
////                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
////                        .addGroup(groupLayout.createSequentialGroup()
////                                .addGap(61)
////                                .addComponent(firstTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
////                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
////                                .addComponent(secondTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
////                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
////                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
////                                        .addComponent(findPathButton)
////                                        .addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
////                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
////                                .addComponent(urlScrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
////                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
////                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
////                                        .addComponent(pathScrollPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
////                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
////                                .addContainerGap())
////        );
////        frame.getContentPane().setLayout(groupLayout);
//
//
//        final File urlFile = new File(urlFiles);
//                Scanner sc = null;
//                try {
//                    sc = new Scanner(urlFile);
//                } catch (FileNotFoundException ex) {
//                    throw new RuntimeException(ex);
//                }
//                String[] urls = sc.next().split(",");
//        sc.close();
//        setUrlList(urls);
//        for(String url: urlLists){
//            try {
//                setHash(url);   //add every word to the hashtable
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//            count++;   // no of documents
//        }
//        //setVertexAndEdges(urls);
//        //this.graph = new Graph(vertexList, edgeList);
//        //textArea.setText(getUrlText());
//        setVertexAndEdges(urls);
//        Graph graph = new Graph(vertexList, edgeList);
//        disjointList = graph.disjoint();
//        System.out.println(getDisjoint(disjointList));
//                try {
//                    serialieFile();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//
//            }
//
//    private void initComponents() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Graph Visualization");
//
//        // Create UI components
//        JComboBox<String> siteComboBox1 = new JComboBox<>(getSiteNames());
//        JComboBox<String> siteComboBox2 = new JComboBox<>(getSiteNames());
//        JButton findPathButton = new JButton("Find Shortest Path");
//
//        // Set layout
//        setLayout(new BorderLayout());
//
//        // Create a JPanel for drawing the graph
//        graphPanel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                // Draw the graph here using the 'graph' object
//                // You may need to adjust this based on your graph structure
//                // Example: Draw vertices and edges
//                for (Edge edge : edgeList) {
//                    Vertex start = edge.getSource();
//                    Vertex end = edge.getDestination();
//                    if(start!= null && end != null){
//                    g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());}
//                }
//            }
//        };
//
//        // Add components to the frame
//        add(graphPanel, BorderLayout.CENTER);
//        JPanel controlPanel = new JPanel();
//        controlPanel.setPreferredSize(new Dimension(1000, 1000));
//        controlPanel.setLayout(new FlowLayout());
//        controlPanel.add(new JLabel("Select Site 1:"));
//        controlPanel.add(siteComboBox1);
//        controlPanel.add(new JLabel("Select Site 2:"));
//        controlPanel.add(siteComboBox2);
//        controlPanel.add(findPathButton);
//       // controlPanel.add(new TextArea("The number of disjoints are: " + graph.getDisjointCount() + "\n" + getDisjoint(disjointList)));
//        add(controlPanel, BorderLayout.SOUTH);
//        pack();
//        setLocationRelativeTo(null); // Center the frame on the screen
//        setVisible(true);
//
//        // Add action listener for the Find Path button
//        findPathButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String siteName1 = (String) siteComboBox1.getSelectedItem();
//                String siteName2 = (String) siteComboBox2.getSelectedItem();
//                displayShortestPath(siteName1, siteName2);
//            }
//        });
//
//
//    }
//
//    private String[] getSiteNames() {
//        // Retrieve site names from your graph and return as an array
//        List<String> siteNames = new ArrayList<>();
//        for (Vertex vertex : vertexList) {
//            siteNames.add(vertex.getName());
//        }
//        return siteNames.toArray(new String[0]);
//    }
//
//    private void displayShortestPath(String siteName1, String siteName2) {
//        // Perform shortest path calculation and update the graphPanel to display the result
//        // You can use your existing shortest path logic here
//        // Example:
//        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
//        Vertex startVertex = getVertexByName(siteName1);
//        Vertex endVertex = getVertexByName(siteName2);
//        shortestPath.calculate(startVertex);
//        List<Vertex> path = shortestPath.getShortestPath(endVertex);
//
//        // Repaint the graphPanel to update the displayed path
//        graphPanel.repaint();
//    }
//
//
//    private Vertex getVertexByName(String name){
//        for(Vertex vertex: vertexList){
//            if(vertex.getName().equals(name)){
//                return vertex;
//            }
//        }
//        return null;
//    }
//
//    public void setUrlList(String[] urls){
//        JsoupScraper scraper = new JsoupScraper();
//        for (String url: urls){
//            medoids.add(url);
//            urlLists.add(url);
//            urlCount++;
//            String[] links = scraper.getLinks(url);
//            for(String link: links){
//                if (link.contains("en.wikipedia.org") && !Character.isDigit(link.charAt(link.length() - 1))
//                        && !urlLists.contains(link) && !link.contains("Main_Page")){
//                    urlLists.add(link);
//                    urlCount++;
//                    if(urlCount == 1000)
//                        break;
//                }
//            }
//        }
//    }
//
//    public void setHash(String link) throws IOException {
//        Document urlDoc = new Document("");
//        HashTable urlHash = new HashTable();
//        try{
//            urlDoc = Jsoup.connect(link).get();
//        }catch (Exception e){
//            urlLists.remove(link);
//            urlCount--;
//            return;
//        }
//        String[] urlWordCount = urlDoc.body().text().split("");
//        for(int j=0; j<urlWordCount.length; j++){
//            urlHash.add(urlWordCount[j].toLowerCase());
//        }
//        for(int i = 0; i< urlHash.table.length; ++i){
//            for(HashTable.Node p = urlHash.table[i]; p!= null; p = p.next){
//                frequencyHash.add(p.key.toLowerCase());
//            }
//        }
//
//    }
//
//    public double tfidfCount (int wordFrequency, int totalDocuments, int totalWords, int documentFrequency){
//        double tf = (double) documentFrequency/(double) totalWords;
//        double idf = Math.log((double) totalDocuments/ (double) wordFrequency);
//        double tfidf = tf * idf;
//        return Math.abs(tfidf);
//    }
//
//    public String getDisjoint(List<String> list){
//        String text = "";
//        for(String item: list){
//            text = text + item + "\n";
//        }
//        return text;
//    }
//
//    public void setVertexAndEdges(String[] urls){
//        int columns = 5;
//        int rows = 5;
//        int gridSize = 100;
//
//        for(int i = 0; i<urls.length ; i++) {
//            int columnIndex = i % columns;
//            int rowIndex = i / columns;
//            int xCoordinate = columnIndex * gridSize;
//            int yCoordinate = rowIndex * gridSize;
//            JsoupScraper scraper = new JsoupScraper();
//            for (String url : urls) {
//                Vertex v = new Vertex(url, xCoordinate, yCoordinate);
//                double fc = getUrlFC(url);
//                String[] links = scraper.getLinks(url);
//                for (String link : links) {
//                    if (link.contains("en.wikipedia.org") && !Character.isDigit(link.charAt(link.length() - 1)) && !link.contains("Main_Page")) {
//                        double fcLink = getUrlFC(link);
//                        Vertex vLink = new Vertex(link, xCoordinate, yCoordinate);
//                        if (vLink != null) {
//                            Edge linkToNull = new Edge(0, vLink, null);
//                            Edge linkToSource = new Edge(fc, vLink, v);
//                            Edge sourceToLink = new Edge(fcLink, v, vLink);
//                            vLink.addEdge(linkToNull);
//                            vLink.addEdge(linkToSource);
//                            v.addEdge(sourceToLink);
//                            edgeList.add(linkToNull);
//                            edgeList.add(linkToSource);
//                            edgeList.add(sourceToLink);
//                            vertexList.add(vLink);
//                        }
//                    }
//                }
//                vertexList.add(v);
//            }
//        }
//    }
//
//    public String getUrlText(){
//        String text = "";
//        for(String url: urlLists){
//            if(url != null){
//                text = text + url + "\n";
//            }
//        }
//        return text;
//    }
//
//    public int count = 0;
//    private JScrollPane scrollPane;
//
//    public double getUrlFC(String url){
//        Document doc;
//        HashTable hash = new HashTable();
//        double fc  = 0;
//        String text = "";
//        count ++;
//        try{
//            doc = Jsoup.connect(url).get();
//        }catch (Exception e){
//            return  -1;
//        }
//        text = doc.body().text();
//        String[] wordCount = text.split(" ");
//        for(int i = 0; i< wordCount.length; i++){
//            hash.add(wordCount[i].toLowerCase());
//        }
//        for(int i = 0; i< hash.table.length; i++){
//            for(HashTable.Node p = hash.table[i]; p != null ; p = p.next ){
//                fc = tfidfCount(urlCount, frequencyHash.get(p.key.toLowerCase()),hash.table.length, hash.get(p.key.toLowerCase())) + fc;
//            }
//        }
//        return fc;
//    }
//
//    public void serialieFile() throws IOException{
//        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "Urls.ser");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(edgeList);
//        fileOutputStream.close();
//        objectOutputStream.close();
//
//    }
//
//
//
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(GraphVisualization::new);
//    }
//}
