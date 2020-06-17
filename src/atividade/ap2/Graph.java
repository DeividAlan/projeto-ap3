/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.ap2;
import java.util.*;

/**
 *
 * @author Deivid
 */
public class Graph {
    private static final int UNDEFINED = -1;
    private int vertices[][];

    public Graph(int numVertices) {
        vertices = new int[numVertices][numVertices];
    }

    public void makeEdge(int vertex1, int vertex2, int time) {
        vertices[vertex1][vertex2] = time;
        vertices[vertex2][vertex1] = time;
    }

    public int getCost(int vertex1, int vertex2) {
        return vertices[vertex1][vertex2];
    }

    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < vertices[vertex].length; i++)
            if (vertices[vertex][i] > 0) {
                neighbors.add(i);
            }

        return neighbors;
    }

    public List<Integer> path(int from, int to) {
        int cost[] = new int[vertices.length];
        int prev[] = new int[vertices.length];
        Set<Integer> unvisited = new HashSet<>();
        cost[from] = 0;

        for (int v = 0; v < vertices.length; v++) {
            if (v != from) {
                cost[v] = Integer.MAX_VALUE;
            }
            prev[v] = UNDEFINED;
            unvisited.add(v);
        }

        while (!unvisited.isEmpty()) {
            int near = closest(cost, unvisited);
            unvisited.remove(near);

            for (Integer neighbor : getNeighbors(near)) {
                int totalCost = cost[near] + getCost(near, neighbor);
                if (totalCost < cost[neighbor]) {
                    cost[neighbor] = totalCost;
                    prev[neighbor] = near;
                }
            }
            if (near == to) {
                return makePathList(prev, near);
            }
        }
        return Collections.emptyList();
    }

    private int closest(int[] dist, Set<Integer> unvisited) {
        double minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        for (Integer i : unvisited) {
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private List<Integer> makePathList(int[] prev, int u) {
        List<Integer> path = new ArrayList<>();
        path.add(u);
        while (prev[u] != UNDEFINED) {
            path.add(prev[u]);
            u = prev[u];
        }
        Collections.reverse(path);
        return path;
    }
    
}
