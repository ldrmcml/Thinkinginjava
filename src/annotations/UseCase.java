package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)// 定义元注解将用于什么地方（一个方法或者一个域）
@Retention(RetentionPolicy.RUNTIME)// 定义注解在哪一个级别可用（SOURCE/CLASS/RUNTIME）
public @interface UseCase {
	public int id();
	public String description() default "no description";
}
