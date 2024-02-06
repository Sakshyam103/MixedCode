//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import java.awt.*;
//import java.awt.font.GraphicAttribute;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import javax.swing.*;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//
//public class Main {
//
//    private JFrame frame;
//    private JTextField firstTextField;
//    private JTextField secondTextField;
//    private JScrollPane urlScrollPane;
//    private JScrollPane pathScrollPane;
//    private JList label;
//    private static final String PATH = "C:/Users/nepal/IdeaProjects/CSC365/src";
//    private static final String urlFiles = "C:/Users/nepal/IdeaProjects/CSC365/src/Urls.txt";
//    int urlCount = 0;
//
//    List<Vertex> vertexList = new ArrayList<Vertex>();
//    List<Edge> edgeList = new ArrayList<>();
//    List<String> urlLists = new CopyOnWriteArrayList<String>();
//    List<String> medoids = new ArrayList<String>();
//    final HashTable frequencyHash = new HashTable();
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    Main window = new Main();
//                    window.frame.setVisible(true);
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//    public Main() throws IOException{
//        initialize();
//    }
//
//    private void initialize() throws IOException{
//        frame = new JFrame();
//        frame.setBounds(100,100,600,600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().setBackground(Color.GRAY);
//        JTextArea textArea = new JTextArea(5, 30);
//        JTextArea pathTextArea = new JTextArea(5,30);
//        final JTextArea shortestPathTextArea = new JTextArea(5, 30);
//        firstTextField = new JTextField();
//        firstTextField.setColumns(10);
//        secondTextField = new JTextField();
//        secondTextField.setColumns(10);
//        JButton findPathButton = new JButton("Click here");
//        findPathButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String firstUrl = firstTextField.getText();
//                String secondUrl = secondTextField.getText();
//                DijkstraShortestPath shortestPath = new DijkstraShortestPath();
//                Vertex one = new Vertex("");
//                Vertex two = new Vertex("");
//                for (Vertex v: vertexList){
//                    if(v.getName().equals(firstUrl)){
//                        one = v;
//                        System.out.println("Found one");
//                    }
//                    if(v.getName().equals(secondUrl)){
//                        two = v;
//                        System.out.println("Found second");
//                    }
//                }
//                shortestPath.calculate(one);
//                List<Vertex> path = new ArrayList<Vertex>();
//                path = shortestPath.getShortestPath(two);
//                String pathText = "";
//                for(Vertex v: path){
//                    pathText = pathText + v.getName() + "\n";
//                }
//                for (String medoid: medoids){
//                    if (pathText.contains(medoid)){
//                        pathText = pathText + "Medoid: " + medoid + "\n";
//                    }
//                }
//                shortestPathTextArea.setText(pathText);
//            }
//        });
//        urlScrollPane = new JScrollPane(textArea);
//        pathScrollPane = new JScrollPane(pathTextArea);
//        scrollPane = new JScrollPane(shortestPathTextArea);
//        JList list = new JList();
//        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
//        groupLayout.setHorizontalGroup(
//                groupLayout.createParallelGroup(Alignment.LEADING)
//                        .addGroup(groupLayout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
//                                        .addGroup(groupLayout.createSequentialGroup()
//                                                .addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(ComponentPlacement.RELATED)
//                                                .addComponent(findPathButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
//                                        .addComponent(firstTextField, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
//                                        .addComponent(secondTextField, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
//                                        .addComponent(urlScrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
//                                        .addGroup(groupLayout.createSequentialGroup()
//                                                .addComponent(pathScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(ComponentPlacement.RELATED)
//                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(ComponentPlacement.RELATED)))
//                                .addContainerGap(207, Short.MAX_VALUE))
//        );
//        groupLayout.setVerticalGroup(
//                groupLayout.createParallelGroup(Alignment.LEADING)
//                        .addGroup(groupLayout.createSequentialGroup()
//                                .addGap(61)
//                                .addComponent(firstTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(ComponentPlacement.RELATED)
//                                .addComponent(secondTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(ComponentPlacement.RELATED)
//                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
//                                        .addComponent(findPathButton)
//                                        .addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
//                                .addPreferredGap(ComponentPlacement.RELATED)
//                                .addComponent(urlScrollPane, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
//                                        .addComponent(pathScrollPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
//                                .addContainerGap())
//        );
//        frame.getContentPane().setLayout(groupLayout);
//        final File urlFile = new File(urlFiles);
//        Scanner sc = new Scanner(urlFile);
//        String[] urls = sc.next().split(",");
//        sc.close();
//        setUrlList(urls);
//        for(String url: urlLists){
//            setHash(url);   //add every word to the hashtable
//            count++;   // no of documents
//        }
//        textArea.setText(getUrlText());
//        setVertexAndEdges(urls);
//        Graph graph = new Graph(vertexList, edgeList);
//        List<String> disjointList = graph.disjoint();
//        System.out.println(getDisjoint(disjointList));
//        pathTextArea.setText("The number of disjoints are: " + graph.getDisjointCount() + "\n" + getDisjoint(disjointList));
//        serialieFile();
//
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
//                && !urlLists.contains(link) && !link.contains("Main_Page")){
//                    urlLists.add(link);
//                    urlCount++;
//                    if(urlCount == 1000)
//                        break;
//                }
//            }
//        }
//    }
//
//    public void setHash(String link) throws IOException{
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
//        JsoupScraper scraper = new JsoupScraper();
//         for(String url: urls){
//             Vertex v = new Vertex(url);
//             double fc = getUrlFC(url);
//             String[] links = scraper.getLinks(url);
//             for (String link: links){
//                 if(link.contains("en.wikipedia.org") && !Character.isDigit(link.charAt(link.length() - 1)) && !link.contains("Main_Page")){
//                     double fcLink = getUrlFC(link);
//                     Vertex vLink = new Vertex(link);
//                     Edge linkToNull = new Edge(0, vLink, null);
//                     Edge linkToSource = new Edge(fc, vLink, v);
//                     Edge sourceToLink = new Edge(fcLink , v , vLink);
//                     vLink.addEdge(linkToNull);
//                     vLink.addEdge(linkToSource);
//                     v.addEdge(sourceToLink);
//                     edgeList.add(linkToNull);
//                     edgeList.add(linkToSource);
//                     edgeList.add(sourceToLink);
//                     vertexList.add(vLink);
//                 }
//             }
//             vertexList.add(v);
//         }
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
//}