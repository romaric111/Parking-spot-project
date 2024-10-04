package projetProg2;

import java.util.ArrayList;
import java.util.List;

public class Graph{
	/**
	 * @author Japha Fomen, aidé par google aussi
 *@version 1.0
 *@since 2023
	 */
List<List<Edge>> adjList = null;

// Constructeur
Graph(List<Edge> edges, int n)
{
    adjList = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
    }

    // ajoute des arêtes au graphe orienté
    for (Edge edge: edges) {
        adjList.get(edge.source).add(edge);
    }
}
}