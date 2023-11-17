package graphs;
import java.util.*;
public class graphPt3{
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    } 

    static void CreateGraph(ArrayList<Edge> graph[]) { // adjacency matrix of graph is "graph" here
        // this arraylist has null values not 0
        for (int i = 0; i < graph.length; i++) { // to create zero values on here
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    public static void KahnsAlgo(ArrayList<Edge>[] graph){
        //indegree -> edges coming inside the node;
        //outdegree-> edges going out

        //Fact: a DAG has at least one vertex with indegree 0 and one vertex with outdegree 0
        //lowest indegree means least dependency on other items 
        //kahn's is basically topological sort with BFS

        //note that we dont use any visited array in this, since we add nodes in the queue
        //after their indeg has gone to zero, there's no way to reach that node again since there is no incoming edge

        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.println(curr);

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
         
    }

    public static void calcIndeg(ArrayList<Edge> graph[], int Indeg[]){
        for(int i=0; i< graph.length;i++){
            for(int j=0;j < graph[i].size();j++){
                Edge e = graph[i].get(j);
                Indeg[e.dest]++;
            }
        }
    }
    public static void main(String args[]){
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreateGraph(graph);

        KahnsAlgo(graph);
    }

}