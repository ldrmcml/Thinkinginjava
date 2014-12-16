package test;
public class FinalizationDemo {
	public static void main(String[] args) {
		Cake c1 = new Cake(1);
		Cake c2 = new Cake(2);
		Cake c3 = new Cake(3);
		
		c2 = c3 = c1 = null;
		// 不一定此时回收，虽然调用，但不一定会执行
		System.gc(); //Invoke the Java garbage collector
	}
}

class Cake extends Object {
	private int id;
	public Cake(int id) {
		this.id = id;
		System.out.println("Cake Object " + id + " is created");
	}
	
	protected void finalize() throws java.lang.Throwable {
		super.finalize();
		System.out.println("Cake Object " + id + " is disposed");
	}
} /* Output 不确定:
Cake Object 1 is created
Cake Object 2 is created
Cake Object 3 is created
Cake Object 2 is disposed
Cake Object 3 is disposed
*///:~
