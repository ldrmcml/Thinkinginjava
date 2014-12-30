package concurrency;

//: concurrency/Chopstick.java
// Chopsticks for dining philosophers.

public class Chopstick {
	private final int id;
	private boolean taken = false;
	
	public Chopstick(int id) {
		this.id = id;
	}
	public synchronized
	void take() throws InterruptedException {
		while(taken){
//			System.out.println(Thread.currentThread().getId()+" before wait");
			wait();
		}
//		System.out.println(Thread.currentThread().getId()+" pop while");
		taken = true;
//		System.out.println(Thread.currentThread().getId()+" Chopstick "+id+" taken");
	}
	public synchronized void drop() {
		taken = false;
		notifyAll();
//		System.out.println(Thread.currentThread().getId()+" Chopstick "+id+" dropped");
	}
} ///:~
