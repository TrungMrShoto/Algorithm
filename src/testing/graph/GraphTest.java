package testing.graph;

import algorithm.graph.DirectedGraphAdjacencyList;
import algorithm.graph.GraphAdjacencyList;
import algorithm.graph.GraphMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author : Nguyen Trong TRUNG
 */
public class GraphTest {
    private GraphAdjacencyList initialGraph = new DirectedGraphAdjacencyList();
    {
        initialGraph.insertVertex("A");
        initialGraph.insertVertex("B");
        initialGraph.insertVertex("C");
        initialGraph.insertVertex("D");
        initialGraph.insertVertex("F");
        initialGraph.insertVertex("G");
        initialGraph.insertVertex("I");
        initialGraph.insertEdge("A","B");
        initialGraph.insertEdge("B","C");
        initialGraph.insertEdge("B","F");
        initialGraph.insertEdge("F","C");
        initialGraph.insertEdge("G","F");
        initialGraph.insertEdge("D","I");

    }

    @Test
    public void checkInsertVertex1(){
        GraphAdjacencyList myGraph = new DirectedGraphAdjacencyList();
        int[] actual = new int[3];
        actual[0] = myGraph.insertVertex("A");
        actual[1] = myGraph.insertVertex("B");
        actual[2] = myGraph.insertVertex("C");
        int[] expected = new int[actual.length];
        Arrays.fill(expected,GraphMessage.SUCCESS);
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void checkInsertVertex2(){
        GraphAdjacencyList myGraph = new DirectedGraphAdjacencyList();
        int[] actual = new int[2];
        actual[0] = myGraph.insertVertex("A");
        actual[1] = myGraph.insertVertex("A");
        int[] expected = {
                GraphMessage.SUCCESS,
                GraphMessage.DUPLICATE_ERROR
        };
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void checkInsertEdge1(){
        GraphAdjacencyList myGraph = new DirectedGraphAdjacencyList();
        myGraph.insertVertex("A");
        myGraph.insertVertex("B");
        int actual = myGraph.insertEdge("A","B");
        Assertions.assertEquals(GraphMessage.SUCCESS,actual);
    }

    @Test
    public void checkInsertEdge2(){
        GraphAdjacencyList myGraph = new DirectedGraphAdjacencyList();
        myGraph.insertVertex("A");
        myGraph.insertVertex("B");
        int actual = myGraph.insertEdge("A","C");
        Assertions.assertEquals(GraphMessage.NOT_FOUND_VERTEX,actual);
    }

    @Test
    public void checkInsertEdge3(){
        GraphAdjacencyList myGraph = new DirectedGraphAdjacencyList();
        myGraph.insertVertex("A");
        myGraph.insertVertex("B");
        int actual = myGraph.insertEdge("D","C");
        Assertions.assertEquals(GraphMessage.NOT_FOUND_VERTEX,actual);
    }

    @Test
    public void checkDeleteVertex1(){
        int actual = this.initialGraph.deleteVertex("A");
        Assertions.assertEquals(GraphMessage.SUCCESS,actual);
    }

    @Test
    public void checkDeleteVertex2(){
        int actual = this.initialGraph.deleteVertex("F");
        Assertions.assertEquals(GraphMessage.NOT_FOUND_VERTEX,actual);
    }

    @Test
    public void checkGetNumberOfVertices(){
        int actual = this.initialGraph.getNumberOfVertices();
        int expected = 7;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void checkGetNumberOfEdges(){
        int actual = this.initialGraph.getNumberOfEdges();
        int expected = 6;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void checkDFS(){
        this.initialGraph.depthFirstSearch();
    }

    @Test
    public void checkBFS(){
        this.initialGraph.breadthFirstSearch();
    }

    @Test
    public void checkTopologicalSortingByDFS(){
        String actual = this.initialGraph.getTopologicalSortingDFSMethod();
        String expected = "ABDIGFC";
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void checkTopologicalSortingByBFS(){
        String actual = this.initialGraph.getTopologicalSortingBFSMethod();
        System.out.println(actual);
        String expected = "ADGBIFC";
        Assertions.assertEquals(expected,actual);
    }

}
