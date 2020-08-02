import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

class Node{
    int value;
    List<Node> adjacentNodes;
    Node(int value){
        this.value = value;
    }

    public void addAdjacentNode(Node node){
        this.adjacentNodes.add(node);
    }

    public void addAdjacentNode(int nodeValue){
        this.adjacentNodes.add(new Node(nodeValue));
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("Input.txt"));
        while (true){
            String str = input.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            if (str.equals("exit"))break;
            Node startNode = new Node(Integer.parseInt(stringTokenizer.nextToken()));
            Node endNode = new Node(Integer.parseInt(stringTokenizer.nextToken()));
            startNode.addAdjacentNode(endNode);
        }
    }
}
