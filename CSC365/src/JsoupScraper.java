import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupScraper {
    public static String[] LINKS;  //array of string
    public JsoupScraper(){};

    public String[] getLinks(String url){    //getLinks method
        Document doc = null;   //first the doc is null
        int i = 0;   //int i = 0
        try{
            doc = Jsoup.connect(url).get();   //get the doc using Jsoup connect
            Elements links = doc.select("a[href]");  //select a[href] to find all the hyperlinks
            LINKS = new String[links.size()];   // make a array of string with size = links.size
            for(Element link: links){   // for every links
                LINKS[i] = link.attr("abs:href").toString();
                i++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return LINKS; // return the array of links
    }
}
