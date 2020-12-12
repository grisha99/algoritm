package lesson7;

import java.util.LinkedList;

public class BreadthFirstPath extends FirstPath{

    public BreadthFirstPath(Graph graph, int source) {
        super(graph, source);
    }

    @Override
    protected void find(Graph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        getMarked()[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : graph.getAdjList(vertex)) {
                if (!getMarked()[w]) {
                    getMarked()[w] = true;
                    getEdgeTo()[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }
}
