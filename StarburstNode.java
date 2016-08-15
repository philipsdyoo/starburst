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
    public StarburstNode[] connections;
    
    public StarburstNode(int id)
    {
        this.id = id;
        visited = false;
    }
    
    public void setConnections(StarburstNode[] nodes)
    {
        connections = nodes;
    }
    
    public String toString()
    {
        return Integer.toString(id);
    }
    
    public void checkPath(Stack<StarburstNode> stack, Set<String> paths)
    {
        //End of path
        if (visited)
        {
            if (stack.size() == 8)
                paths.add(stack.toString());
            return;
        }
        
        visited = true;
        stack.push(this);
        for (StarburstNode node: connections)
        {
            //Recurse through each connected node
            node.checkPath(stack, paths);
        }
        stack.pop();
        visited = false;
    }
}
