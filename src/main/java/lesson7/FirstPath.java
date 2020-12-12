package lesson7;

import java.util.LinkedList;

public abstract class FirstPath {

    private boolean[] marked;
    private int[] edgeTo;
    private int v;

    public FirstPath(Graph graph, int source) {
        this.v = source;
        edgeTo = new int[graph.getVertexCount()];
        marked = new boolean[graph.getVertexCount()];
        find(graph, source);
    }

    public boolean hasPathTo(int dist){
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist){
        if(!hasPathTo(dist)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = dist;
        while(vertex != v){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    protected abstract void find(Graph graph, int v);

    public boolean[] getMarked() {
        return marked;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }

    public int getV() {
        return v;
    }
}
