/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.ap2;

/**
 *
 * @author Deivid
 */
public class Dijkstra {
    
    private static final int Arad = 0;
    private static final int Bucharest = 1;
    private static final int Craiova = 2;
    private static final int Dobreta = 3;
    private static final int Eforie = 4;
    private static final int Fagaras = 5;
    private static final int Giurgiu = 6;
    private static final int Hirsova = 7;
    private static final int Iasi = 8;
    private static final int Lugoj = 9;
    private static final int Mehadia = 10;
    private static final int Neamt = 11;
    private static final int Oradea = 12;
    private static final int Pitesti = 13;
    private static final int Rimmicu = 14;
    private static final int Sibiu = 15;
    private static final int Timisoara = 16;
    private static final int Urziceni = 17;
    private static final int Vaslui = 18;
    private static final int Zerind = 19;
    
    private static String retDijkstra = "";
    
    static String[] cidades = {"Arad", "Bucharest", "Craiova", "Dobreta", "Eforie", "Fagaras",
    		"Giurgiu", "Hirsova", "Iasi", "Lugoj", "Mehadia", "Neamt", "Oradea", "Pitesti",
    		"Rimmicu", "Sibiu", "Timisoara", "Urziceni", "Vaslui", "Zerind"};


    private static int readCity(String type, String line) {
       // while (true) {
            //System.out.println(type + ":");
            //String line = in.nextLine().trim();
       //     if (line.isEmpty()) {
       //         System.out.println("Finished");
       //         System.exit(0);
      //      }
            try {
            	for(int i = 0; i < cidades.length; i++) {
            		if (line.equals(cidades[i])) {
            			return i;
            		}
            	}
            } catch (NumberFormatException e) {
            }
            System.out.println("Wrong name or invalid city, try again");
       // }
        return -1;
    }


    public static String dijkstraBusca(String origem, String destino) {
    	
        Graph trajectories = new Graph(20);

        trajectories.makeEdge(Oradea, Zerind, 71);
        trajectories.makeEdge(Oradea, Sibiu, 151);
        trajectories.makeEdge(Zerind, Arad, 75);
        trajectories.makeEdge(Arad, Sibiu, 140);
        trajectories.makeEdge(Arad, Timisoara, 118);
        trajectories.makeEdge(Timisoara, Lugoj, 111);
        trajectories.makeEdge(Lugoj, Mehadia, 70);
        trajectories.makeEdge(Mehadia, Dobreta, 75);
        trajectories.makeEdge(Dobreta, Craiova, 120);
        trajectories.makeEdge(Sibiu, Fagaras, 99);
        trajectories.makeEdge(Sibiu, Rimmicu, 80);
        trajectories.makeEdge(Rimmicu, Craiova, 146);
        trajectories.makeEdge(Rimmicu, Pitesti, 97);
        trajectories.makeEdge(Pitesti, Craiova, 138);
        trajectories.makeEdge(Pitesti, Bucharest, 101);
        trajectories.makeEdge(Fagaras, Bucharest, 211);
        trajectories.makeEdge(Bucharest, Giurgiu, 90);
        trajectories.makeEdge(Bucharest, Urziceni, 90);
        trajectories.makeEdge(Urziceni, Hirsova, 98);
        trajectories.makeEdge(Urziceni, Vaslui, 142);
        trajectories.makeEdge(Vaslui, Iasi, 92);
        trajectories.makeEdge(Iasi, Neamt, 92);
        trajectories.makeEdge(Hirsova, Eforie, 85);

      //  Scanner in = new Scanner(System.in);

        
       // while (true) {
            //System.out.println("Enter the name of the cities");
            int start = readCity("Start", origem);
            int destination = readCity("Destination", destino);
            if (start != -1 && destination != -1 ){
            //System.out.println("Fastest route:");
                for (Integer station : trajectories.path(start, destination)) {
                  retDijkstra += ((cidades[station]) + " -> ");
                }
            }else{
                retDijkstra = "Alguma Cidade Com o nome invalido, Tente novamente";
            }
            return retDijkstra;
      //      System.out.println("EXIT");
      //  }
    }
}
