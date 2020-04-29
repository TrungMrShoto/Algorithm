package algorithm.graph;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author : Nguyen Trong TRUNG
 */
public class VertexNode {
    private final String key;
    private Map<String,Edge> listOfAdjacencyVertex;
    public int inDegree;
    public int outDegree;
    public boolean isMarked;

    public VertexNode(String key) {
        this.key = key;
        this.listOfAdjacencyVertex = new HashMap();
        this.inDegree = 0;
        this.outDegree = 0;
        this.isMarked = false;
    }

    public String getKey() {
        return key;
    }

    public boolean searchVertex(@NotNull VertexNode vertex)
    {
        String toVertex = vertex.getKey();
        return listOfAdjacencyVertex.containsKey(toVertex);
    }
    public void insertEdge(@NotNull VertexNode vertexTo)
    {
        this.outDegree++;
        vertexTo.inDegree++;
        Edge edge = new Edge(0,this,vertexTo);
        listOfAdjacencyVertex.put(vertexTo.getKey(),edge);
    }
    public void deleteEdge(@NotNull VertexNode vertexTo)
    {
        this.outDegree--;
        vertexTo.inDegree--;
        listOfAdjacencyVertex.remove(vertexTo.getKey());
    }

    public void deleteVertex(@NotNull VertexNode vertex)
    {
        String key = vertex.getKey();
        this.outDegree--;
        listOfAdjacencyVertex.remove(key);
    }
}