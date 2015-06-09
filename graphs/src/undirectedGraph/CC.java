package undirectedGraph;

public class CC {
	private boolean marked[];
	private int[] id;	//id[v] = id of component containing v
	private int count;  //number of components
	
	public CC(Graph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int v = 0; v < G.V(); v++)
		{
			if(!marked[v])
			{
				dfs(G,v); // run DFS from one vertex in each component
				count++;
			}
		}
	}
	
	public int count()
	{ return count; }
	
	public int id(int v)
	{
		return id[v]; 
	}
	
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		for(int w: G.adj(v))
		{
			if(!marked[w])
				dfs(G, w);
		}
	}


}
