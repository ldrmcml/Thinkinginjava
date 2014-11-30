package generics;

//: generics/GenericMethods.java

public class GenericMethodsPractice9 {
  public <T,U,V> void f(T x,V y,U z) {
    System.out.println(x.getClass().getName()+"\t"+y.getClass().getName()
    		+"\t"+z.getClass().getName());
  }
  public static void main(String[] args) {
    GenericMethodsPractice9 gm = new GenericMethodsPractice9();
    gm.f("",1,1.0);
  }
}
