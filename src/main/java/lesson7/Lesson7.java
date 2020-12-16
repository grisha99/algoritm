package lesson7;

public class Lesson7 {
    public static void main(String[] args) {

        Graph graph = new Graph(10);
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(3, 7);
        graph.addEdge(1, 8);
        graph.addEdge(2, 4);
        graph.addEdge(7, 5);
        graph.addEdge(7, 9);
        graph.addEdge(4, 6);
        graph.addEdge(8, 9);
        graph.addEdge(6, 9);

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 2);
        System.out.println(bfp.hasPathTo(8));
        System.out.println(bfp.pathTo(8));

    }
}
