package test;
/**
 * 并不是父类完全初始化完毕后才进行子类的初始化，
 * 实际上子类的静态变量和静态初始化块的初始化是在父类的变量、初始化块和构造器初始化之前就完成.
 * 说明静态变量和静态初始化块是依照他们在类中的定义顺序进行初始化的。同样，变量和初始化块也遵循这个规律。 
 * @author chenminglong
 * 
 */
class Parent {
	// 静态变量
	public static String p_StaticField = "父类--静态变量";
	// 变量
	public String p_Field = "父类--变量";

	// 静态初始化块
	static {
		System.out.println(p_StaticField);
		System.out.println("父类--静态初始化块");
	}

	// 初始化块
	{
		System.out.println(p_Field);
		System.out.println("父类--初始化块");
	}

	// 构造器
	public Parent() {
		System.out.println("父类--构造器");
	}
}

public class SubClass extends Parent {
	// 静态变量
	public static String s_StaticField = "子类--静态变量";
	// 变量
	public String s_Field = "子类--变量";
	// 静态初始化块
	static {
		System.out.println(s_StaticField);
		System.out.println("子类--静态初始化块");
	}
	// 初始化块
	{
		System.out.println(s_Field);
		System.out.println("子类--初始化块");
	}

	// 构造器
	public SubClass() {
		System.out.println("子类--构造器");
	}

	// 程序入口
	public static void main(String[] args) {
		new SubClass();
	}
}