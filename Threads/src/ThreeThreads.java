import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

 
public class ThreeThreads{

	static private AtomicInteger counter = new AtomicInteger(0);

    private static class GlobalCounter implements Runnable{
	    public void run() {
	    	int new_value; 
	    	ArrayList<Integer> collection = new ArrayList<Integer>();   // list of values corresponding
	    																// to a particular thread
	    	
	    	while (counter.get() < 100){
		        new_value = counter.incrementAndGet(); //increase counter and get new_value atmoically
		        collection.add(new_value);
	    		System.out.println(new_value);
	    	}
	    	String threadName = Thread.currentThread().getName();
	    	System.out.println(threadName + " = " + collection);
	    }
    }

    public static void main(String args[]) {
        Thread A = (new Thread(new GlobalCounter(), "Thread-A"));
        Thread B = (new Thread(new GlobalCounter(), "Thread-B"));
        Thread C = (new Thread(new GlobalCounter(), "Thread-C"));
        
        A.start(); B.start(); C.start();
    }

}
