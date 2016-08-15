/**
 * Description: StarburstNode is one of the eight nodes on the board
 * @author: Philip Yoo (philipsdyoo)
 */
import java.util.Set;
import java.util.Stack;

public class StarburstNode
{
    public int id;
    public boolean visited;
    //array of connected nodes
    public StarburstNode[] connections;
    
    public StarburstNode(int id)
    {
        this.id = id;
        visited = false;
    }
    
    /**
     * Set the connected nodes to this node
     * @param nodes = array of connected nodes
     */
    public void setConnections(StarburstNode[] nodes)
    {
        connections = nodes;
    }
    
    /**
     * Returns the id of the node
     */
    public String toString()
    {
        return Integer.toString(id);
    }
    
    /**
     * A recursive function to go through every possible path using Depth-First Traversal.
     * @param path = keeps track of the current path
     * @param solutions = holds all the unique solutions
     */
    public void checkPath(Stack<StarburstNode> path, Set<String> solutions)
    {
        //End of path since this node was already visited
        if (visited)
        {
            //If the current path is a solution (8 nodes), add it to the set
            if (path.size() == 8)
                solutions.add(path.toString());
            return;
        }
        
        //Set this node as visited and add to the current path
        visited = true;
        path.push(this);
        
        //Recurse through each connected node
        for (StarburstNode node: connections)
        {
            node.checkPath(path, solutions);
        }
        //Done with visiting this node, so remove from the current path
        path.pop();
        visited = false;
    }
}
