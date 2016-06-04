import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

 
public class ThreeThreads{

	/**
	 * counter is of type AtomicInteger which supports synchronization and atmoic actions
	 */
	static private AtomicInteger counter = new AtomicInteger(0);
	
	/**
	 * Each thread atomically increments {@code counter} and stores {@code new_value}
	 * in it's {@code collection}. The collection is then printed out after the counter
	 * reaches 100
	 * 
	 * @author sahilagarwal
	 *
	 */
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
	    	System.out.println(threadName + " collection size = "+ collection.size() + " = " + collection);
	    }
    }

    /**
     * Main() creates three threads and starts them at the same time
     * @param args
     */
    public static void main(String args[]) {
        Thread A = (new Thread(new GlobalCounter(), "Thread-A"));
        Thread B = (new Thread(new GlobalCounter(), "Thread-B"));
        Thread C = (new Thread(new GlobalCounter(), "Thread-C"));
      
        A.start(); B.start(); C.start();
        
        
    }

}
