package algorithm.graph;

import org.jetbrains.annotations.NotNull;

/**
 * @author : Nguyen Trong TRUNG
 */
public interface GraphAdjacencyList {
    int insertVertex(@NotNull VertexNode vertexKeyValue);
    int insertVertex(@NotNull String vertexKeyValue);
    int insertEdge(String fromVertex, String toVertex);
    int deleteVertex(String vertexKeyValue);
    int deleteEdge(String fromVertex, String toVertex);
    int getNumberOfEdges();
    int getNumberOfVertices();
}
