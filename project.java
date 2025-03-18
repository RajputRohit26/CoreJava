package com.basic;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class project extends Frame implements ActionListener {

    private static final int V = 28;
    private TextField sourceField, destinationField, distanceField;
    private TextArea outputArea;
    private Button calculateButton;
    private ArrayList<String> buildingList;

    public project() {
        super("Dijkstra Shortest Path Algorithm");

        buildingList = new ArrayList<>();
        buildingList.add("temple");
        buildingList.add("placement office");
        buildingList.add("mens hostel");
        buildingList.add("security gate");
        buildingList.add("TCE CAR");
        buildingList.add("main canteen");
        buildingList.add("NSS cell");
        buildingList.add("bank");
        buildingList.add("NCC");
        buildingList.add("xerox");
        buildingList.add("Physical department");
        buildingList.add("Parking");
        buildingList.add("ground");
        buildingList.add("library");
        buildingList.add("mechanical");
        buildingList.add("tennis");
        buildingList.add("Basket ball");
        buildingList.add("ECE");
        buildingList.add("open auditorium");
        buildingList.add("KM auditorium");
        buildingList.add("KS auditorium");
        buildingList.add("EEE");
        buildingList.add("CIVIL");
        buildingList.add("Fountain");
        buildingList.add("Food court");
        buildingList.add("CSE");
        buildingList.add("IT");
        buildingList.add("b-hALLS");
        buildingList.add("MECT");
        buildingList.add("Girls rest area");
        buildingList.add("back gate");

        // Using FlowLayout for simplicity
        setLayout(new FlowLayout());

        add(new Label("Source Node:"));
        sourceField = new TextField(5);
        add(sourceField);

        add(new Label("Destination Node:"));
        destinationField = new TextField(5);
        add(destinationField);

        calculateButton = new Button("Calculate Path");
        calculateButton.addActionListener(this);
        add(calculateButton);

        outputArea = new TextArea(10, 30);
        outputArea.setEditable(false);
        add(outputArea);

        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            String sourceStr = sourceField.getText();
            String destinationStr = destinationField.getText();

            try {
                int src = Integer.parseInt(sourceStr);
                int dest = Integer.parseInt(destinationStr);

                if (src < 0 || src >= V || dest < 0 || dest >= V) {
                    throw new NumberFormatException("Source and destination must be between 0 and " + (V - 1));
                }

                int[][] graph = {
                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 5, 0, 10, 15, 0, 0, 0, 0, 5, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 15, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    // Add other rows as in the original code...
                };

                int distance = dijkstra(graph, src, dest);

                outputArea.setText("");
                if (distance != Integer.MAX_VALUE) {
                    outputArea.append("Distance from " + buildingList.get(src) + " to " + buildingList.get(dest) + " is: " + distance + "\n");
                    printPath(graph, src, dest, calculateParent(graph, src));
                } else {
                    outputArea.append("Source " + src + " is not connected to vertex " + dest + "\n");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Invalid input: Source and destination must be integers.");
            }
        }
    }

    private static int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static int dijkstra(int[][] graph, int src, int dest) {
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);

        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist[dest];
    }

    private void printPath(int[][] graph, int src, int dest, int[] parent) {
        if (parent[dest] == -1) {
            outputArea.append("No path exists!");
            return;
        }

        if (src == dest) {
            outputArea.append("Source and destination are same");
        } else {
            ArrayList<String> path = new ArrayList<>();
            int v = dest;
            path.add(buildingList.get(v));
            while (v != src) {
                v = parent[v];
                path.add(buildingList.get(v));
            }

            Collections.reverse(path);
            outputArea.append("Path is: ");
            for (String node : path) {
                outputArea.append(node + " -> ");
            }
            outputArea.append("\n");
        }
    }

    private int[] calculateParent(int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        return parent;
    }

    public static void main(String[] args) {
        new project();
    }
}
