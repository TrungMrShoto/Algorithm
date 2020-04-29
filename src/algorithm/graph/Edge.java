package algorithm.graph;

/**
 * @author : Nguyen Trong TRUNG
 */
public class Edge {
    private int weight;
    private VertexNode tail;
    private VertexNode head;

    public Edge(int weight, VertexNode tail, VertexNode head) {
        this.weight = weight;
        this.tail = tail;
        this.head = head;
    }

    public int getWeight() {
        return weight;
    }

    public VertexNode getTail() {
        return tail;
    }

    public VertexNode getHead() {
        return head;
    }
}
