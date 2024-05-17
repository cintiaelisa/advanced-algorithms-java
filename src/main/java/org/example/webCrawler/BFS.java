package org.example.webCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFS {

    // contains the URLs such as (www.bbc.com or www.facebook.com)
    private Queue<String> queue;
    private List<String> discoveredWebSiteList;

    public BFS() {
        this.queue = new LinkedList<>();
        this.discoveredWebSiteList = new ArrayList<>();
    }

    // root is the starting URL (www.bbc.com) for the algorithm
    public void discoverWeb(String root) {

        this.queue.add(root);
        this.discoveredWebSiteList.add(root);

        while(!this.queue.isEmpty()) {

            String visited = this.queue.remove();
            String rawHtml = readURL(visited);

            String regexp = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()) {
                String url = matcher.group();
                if (!discoveredWebSiteList.contains(url)) {
                    discoveredWebSiteList.add(url);
                    queue.add(url);
                    System.out.println("Website found: " + url);
                }
            }
        }
    }

    // read the HTML content of a given website (visited)
    // and return with a String format
    private String readURL(String visited) {
        StringBuilder rawHtml = new StringBuilder("");

        try {
            URL url = new URL(visited);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = "";

            while ((line = reader.readLine())!=null) {
                rawHtml.append(line);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Problem while crawling website");
        }

        return rawHtml.toString();
    }

}
