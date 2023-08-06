
package graphs;
import java.util.*;

public class graphPt2 {
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

    //0(V+E)
    public static boolean DetectCycle(ArrayList<Edge>[] graph) { // this method is separate from the util to check all
                                                                 // components in the graph and
        // not just the connected from the source ones
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {

                if (DetectCycleUtil(graph, vis, 0, -1)) {
                    return true;
                }
            }
        }
        return false;

    }


    //the below approach wont work for directed graphs, because of the parent approach
    public static boolean DetectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int prnt) { // prnt is
                                                                                                        // parent node->
                                                                                                        // the last node
                                                                                            // visited
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 1:
            if (!vis[e.dest] ) { // not visited so go to next
                if( DetectCycleUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }

            // case 2:
            else if (vis[e.dest] && e.dest != prnt) { // not parent but visited
                return true;
            }
            // case 3: parent and visited: do nothing
        }

        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int color[] = new int[graph.length];
        for(int i=0;i <color.length;i++){
            color[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){ //if not colored yet, perform bfs
                q.add(i); 
                color[i] = 0; //yellow
                while(q.isEmpty()){
                    int curr = q.remove();
                    for(int j = 0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j); //e.dest
                        if(color[e.dest] == -1){ //no color
                            int nextcol = color[curr] ==0? 1:0; //blue if prev color was yellow otherwise yellow
                            color[e.dest] = nextcol;
                            q.add(e.dest);
                        }else if(color[e.dest] == color[curr]){
                            return false; //NOT BIPARTITE
                        }
                        //if e.dest's color is different, then well and good, do nothing
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        //boolean stack will track if the current stack of recursion has a value
        //in it rn or not

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph, i , vis, stack)){
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){ //case 1: if it exists in the current stack of calls,
                //meaning it has a cycle fosho
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){//case 2
                return true;
            }
            }
        
        stack[curr] = false; //this resets the stack for the next call to util
        //this line separates this algo from the parent approach
        return false;

    }

    public static void TopologicalSorting(ArrayList<Edge>[] graph){
        //works only for directed acylclic graphs(DAGs)
        //an order where all vertices are arranged in a list such that for every u->v in the graph
        //u comes before v in that list

        //this is used to know dependencies(prerequisits) for doing something 
        //DFS is used

        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length;i++){
            if(!vis[i]){
                TopSortUtil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+ " ");
        }
    }

    public static void TopSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                TopSortUtil(graph, e.dest, vis, s);
            }
            
        }
        s.push(curr);
    }
    public static void main(String args[]){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);

        System.out.println(DetectCycle(graph));
        System.out.println(isBipartite(graph));
        TopologicalSorting(graph);
    }
}
