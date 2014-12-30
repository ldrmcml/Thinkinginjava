//: concurrency/ExplicitCriticalSection.java
// Using explicit Lock objects to create critical sections.
package concurrency;
import java.util.concurrent.locks.*;

// Synchronize the entire method:
class ExplicitPairManager1 extends PairManager {
	private Lock lock = new ReentrantLock();
	public synchronized void increment() {
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			store(getPair());
		} finally {
			lock.unlock();
		}
	}
}

// Use a critical section:
class ExplicitPairManager2 extends PairManager {
	private Lock lock = new ReentrantLock();
	public void increment() {
		Pair temp;
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		} finally {
			lock.unlock();
		}
		store(temp);
	}
}

public class ExplicitCriticalSection {
	public static void main(String[] args) throws Exception {
		PairManager
		pman1 = new ExplicitPairManager1(),
		pman2 = new ExplicitPairManager2();
		CriticalSection.testApproaches(pman1, pman2);
	}
} /* Output: (Sample)
pm1: Pair: x: 15, y: 15 checkCounter = 174035
pm2: Pair: x: 16, y: 16 checkCounter = 2608588

Exception in thread "pool-1-thread-4" concurrency.Pair$PairValuesNotEqualException: Pair values not equal: x: 1, y: 0
	at concurrency.Pair.checkState(CriticalSection.java:33)
	at concurrency.PairChecker.run(CriticalSection.java:102)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at java.lang.Thread.run(Thread.java:745)
pm1: Pair: x: 9, y: 9 checkCounter = 33
pm2: Pair: x: 10, y: 10 checkCounter = 122
 *///:~
