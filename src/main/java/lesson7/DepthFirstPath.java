package lesson7;

public class DepthFirstPath extends FirstPath{

    public DepthFirstPath(Graph graph, int source) {
        super(graph, source);
    }

    @Override
    protected void find(Graph graph, int v) {
        getMarked()[v] = true;
        for (int w : graph.getAdjList(v)) {
            if(!getMarked()[w]){
                getEdgeTo()[w] = v;
                find(graph, w);
            }
        }
    }
}
