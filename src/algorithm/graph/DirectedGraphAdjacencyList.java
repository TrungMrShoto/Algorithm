package algorithm.graph;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author : Nguyen Trong TRUNG
 */
public class DirectedGraphAdjacencyList implements GraphAdjacencyList{

    private Map<String,VertexNode> listOfVertex;
    private int numberOfEdges;
    private int numberOfVertices;

    public DirectedGraphAdjacencyList(){
        listOfVertex = new HashMap<>();
        numberOfEdges = 0;
        numberOfVertices = 0;
    }

    public int insertVertex(@NotNull VertexNode vertexKeyValue)
    {
        if(listOfVertex.containsKey(vertexKeyValue.getKey()))
            return GraphMessage.DUPLICATE_ERROR;
        listOfVertex.put(vertexKeyValue.getKey(),vertexKeyValue);
        this.numberOfVertices++;
        return GraphMessage.SUCCESS;
    }
    public int insertVertex(@NotNull String vertexKeyValue){
        VertexNode node = new VertexNode(vertexKeyValue);
        return insertVertex(node);
    }
    public int insertEdge(String fromVertex, String toVertex){
        if(listOfVertex.containsKey(fromVertex) && listOfVertex.containsKey(toVertex)){
            VertexNode vertexFrom = listOfVertex.get(fromVertex);
            VertexNode vertexTo = listOfVertex.get(toVertex);
            if (vertexFrom.searchVertex(vertexTo))
                return GraphMessage.DUPLICATE_ERROR;

            vertexFrom.insertEdge(vertexTo);
            this.numberOfEdges++;
            return GraphMessage.SUCCESS;
        }
        else
            return GraphMessage.NOT_FOUND_VERTEX;
    }

    public int deleteVertex(String vertexKeyValue)
    {
        if(this.listOfVertex.containsKey(vertexKeyValue))
        {
            VertexNode vertex = listOfVertex.get(vertexKeyValue);
            if (vertex.inDegree>0)
                removeEdgeToVertex(vertex);
            this.listOfVertex.remove(vertexKeyValue);
            this.numberOfVertices--;
            return GraphMessage.SUCCESS;
        }
        else
            return GraphMessage.NOT_FOUND_VERTEX;
    }

    private void removeEdgeToVertex(VertexNode vertex) {
        for(Map.Entry<String,VertexNode> entry: listOfVertex.entrySet()){
            if(entry.getKey().equals(vertex.getKey())) continue;
            entry.getValue().deleteVertex(vertex);
        }
    }

    public int deleteEdge(String fromVertex, String toVertex)
    {
        if(listOfVertex.containsKey(fromVertex) && listOfVertex.containsKey(toVertex)){
            VertexNode vertexFrom = listOfVertex.get(fromVertex);
            VertexNode vertexTo = listOfVertex.get(toVertex);
            if (vertexFrom.searchVertex(vertexTo))
            {
                this.numberOfEdges--;
                vertexFrom.deleteEdge(vertexTo);
                return GraphMessage.SUCCESS;
            }
            else{
                return GraphMessage.NOT_FOUND_EDGE;
            }
        }
        else
            return GraphMessage.NOT_FOUND_VERTEX;
    }
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }


}
