package generics;

//: generics/SimplerPets.java
import typeinfo.pets.*;
import java.util.*;
import net.mindview.util.*;

public class SimplerPets {
  public static void main(String[] args) {
	//type arguments inference类型参数推断
//	  Map<Person,List<? extends Pet>> pePeople=new HashMap<Person,List<? extends Pet>>();
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~
