package com.chance.algorithms.graph.adjacentlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p> 使用邻接表来表示无向图 </p>
 *
 * @author chance
 * @date 2023/8/25 09:55
 * @since 1.0
 */
public class Graph {

    /**
     * 节点数量
     */
    private int V;

    /**
     * 邻接表
     */
    private List<List<Integer>> adjacencyList;

    public Graph(int V) {
        this.V = V;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    /**
     * 添加边
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
        adjacencyList.get(w).add(v);
    }

    /**
     * 获取一个节点的所有邻居节点
     *
     * @param v
     * @return
     */
    public List<Integer> getNeighbors(int v) {
        return adjacencyList.get(v);
    }

    public static void main(String[] args) {
        // 节点数量
        int V = 5;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        for (int i = 0; i < V; i++) {
            System.out.print("Node " + i + " is connected to: ");
            List<Integer> neighbors = graph.getNeighbors(i);
            for (Integer neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
