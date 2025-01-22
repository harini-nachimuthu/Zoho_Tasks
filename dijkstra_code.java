public class dijkstra_code {

	public void algorithm(int graph[][],int source) {
		
		int n=graph.length;
		int[]distance=new int[n];
		boolean[] visited=new boolean[n];
		
		for(int i=0;i<n;i++) {
			visited[i]=false;
			distance[i]=Integer.MAX_VALUE;
		}
		
		distance[source]=0;
		for(int i=0;i<n;i++) {
			int u=minimum_distance(distance,visited);
			visited[u]=true;
			
			for(int j=0;j<n;j++) {
				if(!visited[j] && graph[u][j]!=0 && (distance[u]+graph[u][j]) < distance[j]) {
					distance[j] = distance[u] + graph[u][j];  
				}
			}
		}
		 for (int i = 0; i < distance.length; i++) {  
		      System.out.println("Distance from vertex "+source+" to vertex of "+i+" is : "+distance[i]);  
		    }  
	}
	
	public static int minimum_distance(int[] distance,boolean[] visited) {
		int min_distance=Integer.MAX_VALUE;
		int min_vertex=-1;
		
		for(int i=0;i<distance.length;i++) {
			if(!visited[i]&&distance[i]<min_distance) {
				min_distance=distance[i];
				min_vertex=i;
			}
		}
		return min_vertex;
	}
	
	public static void main(String args[]) {
		 int[][] graph = new int[][] {
	            {0,2,0,0,0,0,3},
	            {2,0,3,0,0,0,1},
	            {0,3,0,7,0,2,0},
	            {0,0,7,0,6,0,0},
	            {0,0,0,6,0,5,0},
	            {0,0,2,0,5,0,4},
	            {3,1,0,0,0,4,0}
	        };
			  
		int source=0;
		dijkstra_code code=new dijkstra_code();
		code.algorithm(graph, source);
	}
}
