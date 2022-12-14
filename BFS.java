import java.io.*;
import java.util.*;
class BFS
{
      private int V;
      private LinkedList<Integer> adj[];
      @SuppressWarnings("unchecked")
      BFS(int v)
      {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                  adj[i] = new LinkedList();
      }
      void addedge(int v,int w)
      {
            adj[v].add(w);
      }
      void bfs(int s)
      {
            boolean visited[] = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[s]=true;
            queue.add(s);
            while (queue.size() != 0)
            {
                  s = queue.poll();
                  System.out.print(s+" ");
                  Iterator<Integer> i = adj[s].listIterator();
                  while (i.hasNext())
                  {
                        int n = i.next();
                        if (!visited[n])
                        {
                              visited[n] = true;
                              queue.add(n);
                        }
                  }
            }
            System.out.println();
      }
      public static void main(String args[])
      {
            BFS b = new BFS(4);
            b.addedge(0, 1);
            b.addedge(0, 2);
            b.addedge(1, 2);
            b.addedge(2, 0);
            b.addedge(2, 3);
            b.addedge(3, 3);
            System.out.println();
            System.out.println("Breadth First Traversal "+"starting from vertex 0 : ");
            b.bfs(0);
            System.out.println("Breadth First Traversal "+"starting from vertex 1 : ");
            b.bfs(1);
            System.out.println("Breadth First Traversal "+"starting from vertex 2 : ");
            b.bfs(2);
            System.out.println("Breadth First Traversal "+"starting from vertex 3 : ");
            b.bfs(3);
      }
}