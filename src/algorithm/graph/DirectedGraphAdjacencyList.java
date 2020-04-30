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

    private int insertVertex(@NotNull VertexNode vertexKeyValue)
    {
        if(listOfVertex.containsKey(vertexKeyValue.getKey()))
            return GraphMessage.DUPLICATE_ERROR;
        listOfVertex.put(vertexKeyValue.getKey(),vertexKeyValue);
        this.numberOfVertices++;
        return GraphMessage.SUCCESS;
    }

    @Override
    public int insertVertex(@NotNull String vertexKeyValue){
        VertexNode node = new VertexNode(vertexKeyValue);
        return insertVertex(node);
    }

    @Override
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

    @Override
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

    @Override
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
    @Override
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public void depthFirstSearch() {
        clearMarked();
        System.out.println("Depth-first Search");
        Stack<VertexNode> readyStack = new Stack<>();
        for(Map.Entry<String,VertexNode> entry:listOfVertex.entrySet()){
            if(!entry.getValue().isMarked)
                this.visitDFS(entry.getValue(),readyStack);
        }
    }

    private void visitDFS(VertexNode vertex, Stack<VertexNode> readyStack) {
        readyStack.push(vertex);
        while (!readyStack.isEmpty())
        {
            VertexNode node = readyStack.pop();
            if(node.isMarked) continue;
            System.out.print(node);
            node.isMarked = true;
            List<VertexNode> listVertices = node.getAllSuccessors();
            listVertices.forEach(i->readyStack.push(i));
        }
    }

    @Override
    public void breadthFirstSearch() {
        clearMarked();
        System.out.println("Breadth-first Search");
        Queue<VertexNode> readyQueue = new LinkedList<>();
        for(Map.Entry<String,VertexNode> entry:listOfVertex.entrySet()){
            if(!entry.getValue().isMarked)
                this.visitBFS(entry.getValue(),readyQueue);
        }
    }



    private void visitBFS(VertexNode vertex, Queue<VertexNode> readyQueue) {
        readyQueue.add(vertex);
        while (!readyQueue.isEmpty())
        {
            VertexNode node = readyQueue.remove();
            if(node.isMarked) continue;
            System.out.print(node);
            node.isMarked = true;
            List<VertexNode> listVertices = node.getAllSuccessors();
            listVertices.forEach(i->readyQueue.add(i));
        }
    }

    private void clearMarked()
    {
        for(Map.Entry<String,VertexNode> entry:listOfVertex.entrySet()){
            entry.getValue().isMarked=false;
        }
    }

    @Override
    public String getTopologicalSortingDFSMethod() {
        clearMarked();
        List<VertexNode> verticesWithNoPredecessor=this.getVertexWithNoPredecessor();
        if (verticesWithNoPredecessor.isEmpty())
            return GraphMessage.NOT_FOUND_TOPOLOGICAL_SORTING;
        StringBuilder listOfTopologicalSorting = new StringBuilder();
        Stack<VertexNode> readyStack = new Stack<>();
        verticesWithNoPredecessor.forEach(i->readyStack.push(i));
        while(!readyStack.isEmpty())
        {
            VertexNode node = readyStack.pop();
            if(node.outDegree>0&&!node.isMarked)
            {
                readyStack.push(node);
                List<VertexNode> listSuccessors = node.getAllSuccessors();
                for(VertexNode vertexNode:listSuccessors)
                {
                    if(!vertexNode.isMarked)
                        readyStack.push(vertexNode);
                }
                node.isMarked=true;
            }
            else
            {
                node.isMarked=true;
                listOfTopologicalSorting.append(node.getKey());
            }
        }
        return listOfTopologicalSorting.reverse().toString();
    }

    @Override
    public String getTopologicalSortingBFSMethod() {
        clearMarked();
        List<VertexNode> verticesWithNoPredecessor=this.getVertexWithNoPredecessor();
        if (verticesWithNoPredecessor.isEmpty())
            return GraphMessage.NOT_FOUND_TOPOLOGICAL_SORTING;
        StringBuilder listOfTopologicalSorting = new StringBuilder();
        Queue<VertexNode> readyQueue = new LinkedList<>();
        verticesWithNoPredecessor.forEach(i->readyQueue.add(i));
        while(!readyQueue.isEmpty()) {
            VertexNode node = readyQueue.remove();
            if(node.isMarked) continue;
            node.isMarked = true;
            listOfTopologicalSorting.append(node.getKey());
            List<VertexNode> listSuccessors = node.getAllSuccessors();
            for (VertexNode vertexNode : listSuccessors) {
                if (!vertexNode.isMarked)
                    readyQueue.add(vertexNode);
            }
        }
        return listOfTopologicalSorting.toString();
    }

    private List<VertexNode> getVertexWithNoPredecessor(){
        List<VertexNode> listVertex = new ArrayList<>();
         for(Map.Entry<String,VertexNode> entry:listOfVertex.entrySet()){
             if(entry.getValue().inDegree==0)
                 listVertex.add(entry.getValue());
         }
         return listVertex;
     }

}
