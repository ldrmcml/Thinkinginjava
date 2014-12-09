package generics;

import java.util.HashMap;
import java.util.Map;
import static net.mindview.util.Print.*;

//: generics/ClassTypeCapture.java
class ClassTypeCapture2 {
	Map<String, Class<?>> types = new HashMap<String, Class<?>>();
	public Object createNew(String typename) {
		Class<?> cl = types.get(typename);
		try {
			return cl.newInstance();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			print("Not a registered typename: "+typename);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void addType(String typename, Class<?> kind) {
		types.put(typename, kind);
	}
}
public class E21_ClassTypeCapture<T> {
	public static void main(String[] args) {
		ClassTypeCapture2 ctt = new ClassTypeCapture2();
		ctt.addType("Building", Building.class);
		ctt.addType("House", House.class);
		ctt.addType("Product", Product.class);
		print(ctt.createNew("Building").getClass());
		print(ctt.createNew("House").getClass());
		// Product类没有无参构造器
		ctt.createNew("Product");
		ctt.createNew("Car");
	}
} /* Output:
class generics.Building
class generics.House
java.lang.InstantiationException: generics.Product
	at java.lang.Class.newInstance(Class.java:364)
	at generics.ClassTypeCapture2.createNew(E21_ClassTypeCapture.java:13)
	at generics.E21_ClassTypeCapture.main(E21_ClassTypeCapture.java:39)
Not a registered typename: Car
*///:~
