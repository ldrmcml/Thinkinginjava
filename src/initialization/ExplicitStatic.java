package initialization;

//: initialization/ExplicitStatic.java
// Explicit static initialization with the "static" clause.
import static net.mindview.util.Print.*;

class Cup {
	Cup(int marker) {
		print("Cup(" + marker + ")");
	}
	void f(int marker) {
		print("f(" + marker + ")");
	}
}

class Cups {
	// 静态初始化仅执行一次，当首次生成这个类的一个对象时，或者首次访问属于那个类的静态数据成员时（即便从未生成过那个类的对象）
	static Cup cup1 = new Cup(2);
	static Cup cup2;
	//  static {
	//    cup1 = new Cup(1);
	//    cup2 = new Cup(2);
	//  }
	static void f(){}
	Cups() {
		print("Cups()");
	}
}

public class ExplicitStatic {
	public static void main(String[] args) {
		print("Inside main()");
		//    Cups.cup1.f(99);  // (1)
		Cups.f();
	}
	//   static Cups cups1 = new Cups();  // (2)
	//   static Cups cups2 = new Cups();  // (2)
} /* Output:
Inside main()
Cup(1)
Cup(2)
f(99)
 *///:~
