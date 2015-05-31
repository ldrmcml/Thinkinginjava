package concurrency;

//: concurrency/TestBlockingQueues.java
// {RunByHand}
import java.util.concurrent.*;
import java.io.*;
import static net.mindview.util.Print.*;

class LiftOffRunner implements Runnable {
	private BlockingQueue<LiftOff> rockets;
	public LiftOffRunner(BlockingQueue<LiftOff> queue) {
		rockets = queue;
	}
	public void add(LiftOff lo) {
		try {
			rockets.put(lo);
		} catch(InterruptedException e) {
			print("Interrupted during put()");
		}
	}
	public void run() {
		try {
			while(!Thread.interrupted()) {
				print("1");
				// wait/sleep/join被中断将严格抛出异常
				LiftOff rocket = rockets.take();
				rocket.run(); // Use this thread
				print("2");
			}
			print("3");
		} catch(InterruptedException e) {
			print(rockets.getClass()+" Waking from take()");
		}
		print(rockets.getClass()+" Exiting LiftOffRunner");
	}
}

public class TestBlockingQueues {
	static void getkey() {
		try {
			// Compensate for Windows/Linux difference in the
			// length of the result produced by the Enter key:
			new BufferedReader(
					new InputStreamReader(System.in)).readLine();
		} catch(java.io.IOException e) {
			throw new RuntimeException(e);
		}
	}
	static void getkey(String message) {
		print(message);
		getkey();
	}
	static void
	test(String msg, BlockingQueue<LiftOff> queue) {
		print(msg);
		LiftOffRunner runner = new LiftOffRunner(queue);
		Thread t = new Thread(runner);
		t.start();
//		for(int i = 0; i < 5; i++)
//			runner.add(new LiftOff(5));
		getkey("Press 'Enter' (" + msg + ")");
		// 等待上一句输入之后才执行到interrupt
		t.interrupt();
		print("Finished " + msg + " test");
	}
	public static void main(String[] args) {
		test("LinkedBlockingQueue", // Unlimited size
				new LinkedBlockingQueue<LiftOff>());
		test("ArrayBlockingQueue", // Fixed size
				new ArrayBlockingQueue<LiftOff>(3));
		test("SynchronousQueue", // Size of 1
				new SynchronousQueue<LiftOff>());
	}
} ///:~
