package algo;

public class Dijkstra {
    int V = 0;
    public void dijkstraAlgo(int[][] graph ,int src){
        int[] dist = new int[V];
        Boolean[] Q = new Boolean[V];
        for(int i=0; i<V; i++){
            dist[i] = Integer.MAX_VALUE;
            Q[i] = false;
        }
        dist[src]=0;
        
        for (int i=0; i<V-1; i++){
            int u = ExtractMin(dist , Q);
//            System.out.println(u);
            Q[u] = true;
            
            for(int v=0; v<V ; v++){
//                System.out.print(graph[u][v]);
                if( graph[u][v] != 0 && dist[v] > dist[u] + graph[u][v] ){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        for(int i=0; i< dist.length; i++){
            System.out.println(i+"--"+dist[i]);
        }
    }
    public int ExtractMin(int[] dist, Boolean[] Q){
        int min = Integer.MAX_VALUE ;
        int min_index = -1;
        for(int i=0; i<V; i++){
            if(dist[i] < min && Q[i] != true){
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }
    public static void main(String[] args) {
                      //  s  t   x  y  z
        int graph[][] = {{0, 10, 0, 5, 0 }, //s
                         {0, 0, 1, 2, 0},   //t
                         {0, 0, 0, 0, 4},   //x
                         {0, 3, 9, 0, 2},   //y
                         {2, 0, 6, 0, 0}};  //z
//        System.out.println(graph.length);
        Dijkstra djks = new Dijkstra();
        djks.V = graph.length;
        djks.dijkstraAlgo(graph, 0);
        
    }
}
