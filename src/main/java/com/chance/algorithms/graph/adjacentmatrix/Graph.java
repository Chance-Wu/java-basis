package com.chance.algorithms.graph.adjacentmatrix;

/**
 * <p> 使用邻接矩阵表示无向图 </p>
 *
 * @author chance
 * @date 2023/8/25 10:05
 * @since 1.0
 */
public class Graph {
    /**
     * 节点数量
     */
    private int V;

    /**
     * 邻接矩阵
     */
    private int[][] adjacencyMatrix;

    public Graph(int V) {
        this.V = V;
        adjacencyMatrix = new int[V][V];
    }

    public void addEdge(int v, int w, int weight) {
        adjacencyMatrix[v][w] = weight;
        // 无向图的邻接矩阵是对称的
        adjacencyMatrix[w][v] = weight;
    }

    public int getWeight(int v, int w) {
        return adjacencyMatrix[v][w];
    }

    public static void main(String[] args) {
        // 节点数量
        int V = 5;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 4);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph.getWeight(i, j) + " ");
            }
            System.out.println();
        }
    }
}

