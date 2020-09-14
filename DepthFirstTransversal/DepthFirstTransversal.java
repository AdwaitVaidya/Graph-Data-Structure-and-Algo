package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Vertica {
    int value;
    boolean isTransversed = false;
    private ArrayList<Vertica> adjacentVertices;

    Vertica(int value){
        this.value = value;
        adjacentVertices = new ArrayList<>();
    }

    void addAdjacentVertica(Vertica vertica){
        this.adjacentVertices.add(vertica);
        vertica.adjacentVertices.add(this);
    }

    public void setTransversed(boolean transversed) {
        isTransversed = transversed;
    }

    public boolean isTransversed() {
        return isTransversed;
    }

    ArrayList<Vertica> getAdjacentVertices(){
        return this.adjacentVertices;
    }
    @Override
    public String toString(){
        return String.valueOf(this.value);
    }
}

class Graph{
    int minimumDistance = 0;
    Stack<Vertica> currentStack = new Stack<>();
    Vertica[] verticas;
    Vertica startVertica;

    Graph(Vertica[] verticas){
        this.verticas = verticas;
        this.minimumDistance = verticas.length;
    }

    public void getBreadthFirstTransversal(Vertica startVertica) {
        this.startVertica = startVertica;
        currentStack.push(startVertica);
        backBreadthFirstTransversal(startVertica);
    }

    void backBreadthFirstTransversal(Vertica currentVertica){
        System.out.println(currentVertica);
        currentVertica.setTransversed(true);
        //if (currentVertica == startVertica) return;
        if (currentStack.contains(currentVertica) && currentStack.peek()!= currentVertica){
            currentStack.pop();
        }
        else if (currentStack.contains(currentVertica) && currentStack.peek() == currentVertica){
            for ( Vertica vertica : currentVertica.getAdjacentVertices() ) {
                if (vertica.isTransversed){
                    continue;
                }
                else {
                    currentStack.push(vertica);
                    backBreadthFirstTransversal(vertica);
                }
                System.out.println(currentVertica);
            }
        }
        else if (!currentStack.contains(currentVertica)){
            for ( Vertica vertica : currentVertica.getAdjacentVertices() ) {
                if (vertica.isTransversed){
                    continue;
                }
                else {
                    currentStack.push(vertica);
                    backBreadthFirstTransversal(vertica);
                }
            }
        }
        System.out.println(currentVertica);
    }
}

public class Main {
    static BufferedReader input;
    static Vertica[] vertices;

    static Vertica getVerticaWithValue(int value){
        for (Vertica vertica: vertices) {
            if (vertica.value == value) return vertica;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        vertices = new Vertica[Integer.parseInt(input.readLine())];
        Graph graph;
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertica(i+1);
        }
        String line;
        while ((line = input.readLine()) != null){
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            getVerticaWithValue(Integer.parseInt(stringTokenizer.nextToken())).addAdjacentVertica(
                    getVerticaWithValue(Integer.parseInt(stringTokenizer.nextToken()))
            );
        }
        graph = new Graph(vertices);
        graph.getBreadthFirstTransversal(vertices[0]);

    }
}
