package iteration;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class Client {

	@Test
    public void test(){
    	MyFolder<Integer, String> my = new MyFolder<Integer,String>();
    	
    	Queue<Integer> q = new ArrayDeque<Integer>();
    	q.add(1);
    	q.add(2);
    	q.add(3);
    	Function2 func = new MyFunc();
    	
    	my.fold("reza",q, func);
    }


}
