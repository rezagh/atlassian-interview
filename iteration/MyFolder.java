package iteration;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;


//objective: convert the iterative method to functional
public class MyFolder<T, U> implements Folder<T, U>
{
	
	public U fold(U u, Queue<T> ts, Function2<T, U, U> function)
    {
        if(u == null || ts == null || function == null)
            throw new IllegalArgumentException();
        //System.out.println(u);

        if (ts.isEmpty()) {
            System.out.println(u);
        	return u;
        }
        
        Stack<U> stackU = new Stack<U>();
        //Stack<T> stackT = new Stack<T>();
        
    	stackU.push(function.apply(ts.poll(), u));

        while(!ts.isEmpty()){
        	stackU.push(function.apply(ts.poll(), stackU.pop() ));
        	
        }
//        while(!stackU.isEmpty()){
//        	if(!ts.isEmpty()){
//        		stackU.push(function.apply(ts.poll(), u));
//        		
//        	}else{
//        		U popped = stackU.pop();
//        		function.apply(,u);
//        		
//        	}
//        }
//        
        System.out.println(stackU);
        
        return stackU.pop();

        // The recursive implementation will overflow the stack for
        // any data set of real size, your job is to implement a
        // non-recursive solution
        //return fold(function.apply(ts.poll(), u), ts, function);
        //return null;
        /*

iterativeInorder(node)
  parentStack = empty stack
  while not parentStack.isEmpty() or node != null
    if node != null then
      parentStack.push(node)
      node = node.left
    else
      node = parentStack.pop()
      visit(node)
      node = node.right
      
          
    
    
    
    	*/
    
    }
}