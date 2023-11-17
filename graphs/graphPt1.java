package graphs;
import java.util.*;

public class graphPt1{
    
    static class Edge{
        int src;
        int dest;
        int wt;
        
        public Edge(int s, int d,int w){
            this.src =s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void CreateGraph(ArrayList<Edge> graph[]){ //adjacency matrix of graph is "graph" here 
        //this arraylist has null values not 0
        for(int i = 0; i< graph.length ;i++){ //to create zero values on here
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

    }

    public static void Bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        System.out.println("BFS: ");

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                BfsUtil(graph, vis, i);
            }
        }
    }

    public static void BfsUtil(ArrayList<Edge>[] graph, boolean[] vis, int src){

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        System.out.println(src);
        

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.println(curr);
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                if(!vis[e.dest]){
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }
        }
       
    }

    public static void Dfs(ArrayList<Edge>[] graph){
        System.out.println("DFS: ");
        boolean vis[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                DfsUtil(graph, vis, i);
            }
        }
    }

    public static void DfsUtil(ArrayList<Edge>[] graph, boolean vis[], int src){
        if(!vis[src]){
            vis[src] = true;
        System.out.println(src);
        }
        
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest]){
                System.out.println(e.dest);
                vis[e.dest] = true;
                DfsUtil(graph, vis, e.dest);
            }
        }
        

        
    }

    
    public static void main(String args[]){
        int Vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[Vertices]; //array of arraylist of edges
        CreateGraph(graph);
        Bfs(graph);
        Dfs(graph);
        System.out.println(DetectCycle(graph));
        
    }

}


