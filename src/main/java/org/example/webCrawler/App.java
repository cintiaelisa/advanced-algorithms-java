package org.example.webCrawler;

public class App {

    public static void main(String[] args) {

        BFS bfs = new BFS();
        bfs.discoverWeb("https://www.bbc.com");
    }
}
