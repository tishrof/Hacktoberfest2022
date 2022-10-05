import java.io.*;
import java.util.*;
class DFS
{
      private int V;
      private LinkedList<Integer> adj[];
      @SuppressWarnings("unchecked")
      DFS(int v)
      {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                  adj[i] = new LinkedList();
      }
      void addedge(int v, int w)
      {
            adj[v].add(w);
      }
      void dfs(int v,boolean visited[]) 
      { 
            visited[v] = true;
            System.out.print(v+" ");
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                  int n = i.next();
                  if (!visited[n])
                        dfs(n, visited);
            }
      } 
      void DFS(int v)
      {
            boolean visited[] = new boolean[V];
            dfs(v, visited);
            System.out.println();
      }
      public static void main(String args[])
      {
            DFS d = new DFS(4);
            d.addedge(0, 1);
            d.addedge(0, 2);
            d.addedge(1, 2);
            d.addedge(2, 0);
            d.addedge(2, 3);
            d.addedge(3, 3);
            System.out.println();
            System.out.println("Depth First Traversal "+"starting from vertex 0 : ");
            d.DFS(0);
            System.out.println("Depth First Traversal "+"starting from vertex 1 : ");
            d.DFS(1);
            System.out.println("Depth First Traversal "+"starting from vertex 2 : ");
            d.DFS(2);
            System.out.println("Depth First Traversal "+"starting from vertex 3 : ");
            d.DFS(3);
      }
}