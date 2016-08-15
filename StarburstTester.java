import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Description: Tester for the Starburst game board
 * @author: Philip Yoo (philipsdyoo)
 */

public class StarburstTester
{

    public static void main(String[] args)
    {
        //Creating nodes
        StarburstNode one = new StarburstNode(1);
        StarburstNode two = new StarburstNode(2);
        StarburstNode three = new StarburstNode(3);
        StarburstNode four = new StarburstNode(4);
        StarburstNode five = new StarburstNode(5);
        StarburstNode six = new StarburstNode(6);
        StarburstNode seven = new StarburstNode(7);
        StarburstNode eight = new StarburstNode(8);
        
        // Creating connections
        one.setConnections(new StarburstNode[]{three, five});
        two.setConnections(new StarburstNode[]{five, seven});
        three.setConnections(new StarburstNode[]{one, six, eight});
        four.setConnections(new StarburstNode[]{six, seven, eight});
        five.setConnections(new StarburstNode[]{one, two});
        six.setConnections(new StarburstNode[]{three, four});
        seven.setConnections(new StarburstNode[]{two, four});
        eight.setConnections(new StarburstNode[]{three, four});
        
        //Instantiating the stack (keeps track of current path) and set (holds unique solutions)
        Stack<StarburstNode> path = new Stack<StarburstNode>();
        Set<String> solutions = new HashSet<String>();
        
        //Check for any possible solution paths starting at each of the nodes
        one.checkPath(path, solutions);
        two.checkPath(path, solutions);
        three.checkPath(path, solutions);
        four.checkPath(path, solutions);
        five.checkPath(path, solutions);
        six.checkPath(path, solutions);
        seven.checkPath(path, solutions);
        eight.checkPath(path, solutions);
        
        //Print out the solutions set
        System.out.println(solutions);
    }
}
