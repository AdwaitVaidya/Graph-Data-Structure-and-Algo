import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int totalVertices = Integer.parseInt(input.readLine());
        int[][] edges = new int[totalVertices][totalVertices];

        while (true){
            String str = input.readLine();
            if(str.equals("exit")) break;
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            int verticeStart = Integer.parseInt(stringTokenizer.nextToken());
            int verticeEnd = Integer.parseInt(stringTokenizer.nextToken());
            edges[verticeStart][verticeEnd] = 1;
        }

        System.out.print(" \t");
        for (int i = 0; i < edges.length ; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
        for (int i = 0; i < edges.length; i++) {
            System.out.print(i);
            for (int j = 0; j < edges[0].length; j++) {
                System.out.print("\t"+edges[i][j]);
            }
            System.out.println();
        }
    }
}